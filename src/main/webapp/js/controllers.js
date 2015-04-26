'use strict';

/**
 * The root conferenceApp module.
 * 
 * @type {conferenceApp|*|{}}
 */
var conferenceApp = conferenceApp || {};

/**
 * @ngdoc module
 * @name conferenceControllers
 * 
 * @description Angular module for controllers.
 * 
 */
conferenceApp.controllers = angular.module('fairyshareControllers',
		[ 'ui.bootstrap' ]);

/**
 * @ngdoc controller
 * @name MyProfileCtrl
 * 
 * @description A controller used for the My Profile page.
 */
conferenceApp.controllers
		.controller(
				'MyProfileCtrl',
				function($scope, $log, oauth2Provider, HTTP_ERRORS) {
					$scope.submitted = false;
					$scope.loading = false;

					/**
					 * The initial profile retrieved from the server to know the
					 * dirty state.
					 * 
					 * @type {{}}
					 */
					$scope.initialProfile = {};

					/**
					 * Holds the stories currently displayed in the page.
					 * 
					 * @type {Array}
					 */
					$scope.stories = [];

					/**
					 * Holds the state if offcanvas is enabled.
					 * 
					 * @type {boolean}
					 */
					$scope.isOffcanvasEnabled = false;

					/**
					 * Toggles the status of the offcanvas.
					 */
					$scope.toggleOffcanvas = function() {
						$scope.isOffcanvasEnabled = !$scope.isOffcanvasEnabled;
					};

					/**
					 * Initializes the My profile page. Update the profile if
					 * the user's profile has been stored. Invokes the
					 * fairyshare.myStories method.
					 */
					$scope.init = function() {
						var retrieveProfileCallback = function() {
							$scope.profile = {};
							$scope.loading = true;
							gapi.client.fairyshare.getProfile().execute(
									function(resp) {
										$scope.$apply(function() {
											if (resp.error) {
												// Failed to get a user profile.
												var errorMessage = resp.error.message || '';
												$scope.messages = 'Failed to get profile : ' + errorMessage;
												$scope.alertStatus = 'warning';
												$log.error($scope.messages);
											}
											else {
												// Succeeded to get the user
												// profile.
												$scope.profile.displayName = resp.result.displayName;
												$scope.profile.userUrl = resp.result.userUrl;
												$scope.profile.info = resp.result.info;
												$scope.initialProfile = resp.result;
											}
										});
									});
							gapi.client.fairyshare.myStories().execute(
									function(resp) {
										$scope.$apply(function() {
											$scope.loading = false;
											if (resp.error) {
												// The request has failed.
												var errorMessage = resp.error.message || '';
												$scope.messages = 'Failed to query stories : ' + errorMessage;
												$scope.alertStatus = 'warning';
												$log.error($scope.messages);
											}
											else {
												// The request has succeeded.
												$scope.submitted = false;
												$scope.alertStatus = 'success';
												$log.info($scope.messages);

												$scope.stories = [];
												angular.forEach(resp.items,function(story) {
																	$scope.stories.push(story);
												});
											}
											$scope.submitted = true;
										});
									});
							
						};
						if (!oauth2Provider.signedIn) {
							var modalInstance = oauth2Provider.showLoginModal();
							modalInstance.result.then(retrieveProfileCallback);
						} else {
							retrieveProfileCallback();
						}
					};

					/**
					 * Invokes the conference.saveProfile API.
					 * 
					 */
					$scope.saveProfile = function() {
						$scope.submitted = true;
						$scope.loading = true;/*
						profileForm = {
								displayName : $scope.profile.displayName,
								userUrl : $scope.profile.userUrl,
								info : $scope.profile.info
						};*/
						gapi.client.fairyshare
								.saveProfile(profileForm)
								.execute(
										function(resp) {
											$scope
													.$apply(function() {
														$scope.loading = false;
														if (resp.error) {
															// The request has
															// failed.
															var errorMessage = resp.error.message
																	|| '';
															$scope.messages = 'Failed to update a profile : '
																	+ errorMessage;
															$scope.alertStatus = 'warning';
															$log
																	.error($scope.messages
																			+ 'Profile : '
																			+ JSON
																					.stringify($scope.profile));

															if (resp.code
																	&& resp.code == HTTP_ERRORS.UNAUTHORIZED) {
																oauth2Provider
																		.showLoginModal();
																return;
															}
														} else {
															// The request has
															// succeeded.
															$scope.messages = 'The profile has been updated';
															$scope.alertStatus = 'success';
															$scope.submitted = false;
															$scope.initialProfile = {
																displayName : $scope.profile.displayName,
																userUrl : $scope.profile.userUrl,
																info : $scope.profile.info
															};

															$log
																	.info($scope.messages
																			+ JSON
																					.stringify(resp.result));
														}
													});
										});
					};
				});

/**
 * @ngdoc controller
 * @name CreateStoryCtrl
 * 
 * @description A controller used for the Create story page.
 */
fairyshareApp.controllers.controller('CreateStoryCtrl', function($scope, $log,
		oauth2Provider, HTTP_ERRORS) {

	/**
	 * The conference object being edited in the page.
	 * 
	 * @type {{}|*}
	 */
	$scope.story = $scope.story || {};

	/**
	 * Invokes the fairyshare.createStory API.
	 * 
	 * @param conferenceForm
	 *            the form object.
	 */
	$scope.createStory = function() {

		$scope.loading = true;
		gapi.client.fairyshare.createStory($scope.story).execute(
				function(resp) {
					$scope.$apply(function() {
						$scope.loading = false;
						if (resp.error) {
							// The request has failed.
							var errorMessage = resp.error.message || '';
							$scope.messages = 'Failed to create a story : '
									+ errorMessage;
							$scope.alertStatus = 'warning';
							$log.error($scope.messages + ' Story : '
									+ JSON.stringify($scope.story));

							if (resp.code
									&& resp.code == HTTP_ERRORS.UNAUTHORIZED) {
								oauth2Provider.showLoginModal();
								return;
							}
						} else {
							// The request has succeeded.
							$scope.messages = 'The story has been created : '
									+ resp.result.name;
							$scope.alertStatus = 'success';
							$scope.submitted = false;
							$scope.story = {};
							$log.info($scope.messages + ' : '
									+ JSON.stringify(resp.result));
						}
					});
				});
	};
});

/**
 * @ngdoc controller
 * @name AllStoriesCtrl
 * 
 * @description A controller used for the read story page.
 */
conferenceApp.controllers.controller('AllStoriesCtrl', function($scope, $log,
		oauth2Provider, HTTP_ERRORS) {

	/**
	 * Holds the status if the query is being executed.
	 * 
	 * @type {boolean}
	 */
	$scope.submitted = false;

	/**
	 * Holds the stories currently displayed in the page.
	 * 
	 * @type {Array}
	 */
	$scope.stories = [];

	/**
	 * Holds the state if offcanvas is enabled.
	 * 
	 * @type {boolean}
	 */
	$scope.isOffcanvasEnabled = false;

	/**
	 * Toggles the status of the offcanvas.
	 */
	$scope.toggleOffcanvas = function() {
		$scope.isOffcanvasEnabled = !$scope.isOffcanvasEnabled;
	};

	/**
	 * Invokes the fairyshare.allStories API.
	 */
	$scope.init = function() {

		$scope.loading = true;
		gapi.client.conference.allStories().execute(
				function(resp) {
					$scope.$apply(function() {
						$scope.loading = false;
						if (resp.error) {
							// The request has
							// failed.
							var errorMessage = resp.error.message || '';
							$scope.messages = 'Failed to get stories : '
									+ errorMessage;
							$scope.alertStatus = 'warning';
						} else {
							// The request has
							// succeeded.
							$scope.submitted = false;
							$scope.alertStatus = 'success';
							$log.info($scope.messages);

							$scope.stories = [];
							angular.forEach(resp.items, function(story) {
								$scope.stories.push(story);
							});
						}
						$scope.submitted = true;
					});
				});
	};
});

/**
 * @ngdoc controller
 * @name ReadStoryCtrl
 * 
 * @description A controller used for the read story page.
 */
conferenceApp.controllers.controller('ReadStoryCtrl', function($scope, $log,
		$routeParams, HTTP_ERRORS) {
	$scope.story = {};

	$scope.isUserAttending = false;

	/**
	 * Initializes the read story page. Invokes the fairyshare.loadStory method
	 * and sets the returned story in the $scope.
	 * 
	 */
	$scope.init = function() {
		$scope.loading = true;
		gapi.client.fairyshare.loadStory({
			websafeStoryKey : $routeParams.websafeStoryKey
		}).execute(
				function(resp) {
					$scope.$apply(function() {
						$scope.loading = false;
						if (resp.error) {
							// The request has
							// failed.
							var errorMessage = resp.error.message || '';
							$scope.messages = 'Failed to get the story : '
									+ $routeParams.websafeKey + ' '
									+ errorMessage;
							$scope.alertStatus = 'warning';
							$log.error($scope.messages);
						} else {
							// The request has
							// succeeded.
							$scope.alertStatus = 'success';
							$scope.story = resp.result;
						}
					});
				});
	}
});

/**
 * @ngdoc controller
 * @name MyProfileCtrl
 * 
 * @description A controller used for the Edit Story page.
 */
conferenceApp.controllers.controller('EditStoryCtrl', function($scope, $log,
		oauth2Provider, HTTP_ERRORS) {
	$scope.submitted = false;
	$scope.loading = false;

	/**
	 * The initial profile retrieved from the server to know the dirty state.
	 * 
	 * @type {{}}
	 */
	$scope.initialProfile = {};

	/**
	 * Holds the stories currently displayed in the page.
	 * 
	 * @type {{}}
	 */
	$scope.story = {};

	/**
	 * Holds the state if offcanvas is enabled.
	 * 
	 * @type {boolean}
	 */
	$scope.isOffcanvasEnabled = false;

	/**
	 * Toggles the status of the offcanvas.
	 */
	$scope.toggleOffcanvas = function() {
		$scope.isOffcanvasEnabled = !$scope.isOffcanvasEnabled;
	};

	/**
	 * Initializes the My profile page. Update the profile if the user's profile
	 * has been stored.
	 */
	$scope.init = function() {
		$scope.loading = true;
		gapi.client.fairyshare.loadStory({
			websafeStoryKey : $routeParams.websafeStoryKey
		}).execute(
				function(resp) {
					$scope.$apply(function() {
						$scope.loading = false;
						if (resp.error) {
							// The request has
							// failed.
							var errorMessage = resp.error.message || '';
							$scope.messages = 'Failed to get the story : '
									+ $routeParams.websafeKey + ' '
									+ errorMessage;
							$scope.alertStatus = 'warning';
							$log.error($scope.messages);
						} else {
							// The request has
							// succeeded.
							$scope.alertStatus = 'success';
							$scope.story = resp.result;
						}
					});
				});
	}
	/**
	 * Invokes the conference.saveStory API.
	 * 
	 */
	$scope.createStory = function(storyForm) {

		$scope.loading = true;
		gapi.client.fairyshare.saveStory($scope.story).execute(
				function(resp) {
					$scope.$apply(function() {
						$scope.loading = false;
						if (resp.error) {
							// The request has failed.
							var errorMessage = resp.error.message || '';
							$scope.messages = 'Failed to save story : '
									+ errorMessage;
							$scope.alertStatus = 'warning';
							$log.error($scope.messages + ' Story : '
									+ JSON.stringify($scope.story));

							if (resp.code
									&& resp.code == HTTP_ERRORS.UNAUTHORIZED) {
								oauth2Provider.showLoginModal();
								return;
							}
						} else {
							// The request has succeeded.
							$scope.messages = 'The story has been saved : '
									+ resp.result.name;
							$scope.alertStatus = 'success';
							$scope.submitted = false;
							$scope.story = {};
							$log.info($scope.messages + ' : '
									+ JSON.stringify(resp.result));
						}
					});
				});
	};
});

/**
 * @ngdoc controller
 * @name ReadStoryCtrl
 * 
 * @description A controller used for the read story page.
 */
conferenceApp.controllers.controller('RateStoryCtrl', function($scope, $log,
		$routeParams, HTTP_ERRORS) {

	$scope.isUserAttending = false;

	/**
	 * likes the story.
	 */
	$scope.likeStory = function() {
		gapi.client.fairyshare.likeStory({
			websafeStoryKey : $routeParams.websafeStoryKey
		}).execute(
				function(resp) {
					$scope.$apply(function() {
						$scope.loading = false;
						if (resp.error) {
							// The request has
							// failed.
							var errorMessage = resp.error.message || '';
							$scope.messages = 'Failed to like the story : '
									+ $routeParams.websafeKey + ' '
									+ errorMessage;
							$scope.alertStatus = 'warning';
							$log.error($scope.messages);
						} else {
							// The request has
							// succeeded.
							$scope.alertStatus = 'success';
						}
					});
				});
	}
	/**
	 * dislikes the story.
	 */
	$scope.dislikeStory = function() {
		gapi.client.fairyshare.dislikeStory({
			websafeStoryKey : $routeParams.websafeStoryKey
		}).execute(
				function(resp) {
					$scope.$apply(function() {
						$scope.loading = false;
						if (resp.error) {
							// The request has
							// failed.
							var errorMessage = resp.error.message || '';
							$scope.messages = 'Failed to like the story : '
									+ $routeParams.websafeKey + ' '
									+ errorMessage;
							$scope.alertStatus = 'warning';
							$log.error($scope.messages);
						} else {
							// The request has
							// succeeded.
							$scope.alertStatus = 'success';
						}
					});
				});
	}
});

conferenceApp.controllers.controller('ForkStoryCtrl', function($scope, $log,
		$routeParams, HTTP_ERRORS) {
	$scope.story = {};

	$scope.isUserAttending = false;

	/**
	 * Initializes the read story page. Invokes the fairyshare.loadStory method
	 * and sets the returned story in the $scope.
	 * 
	 */
	$scope.forkStory = function() {
		$scope.loading = true;
		gapi.client.fairyshare.forkStory({
			websafeStoryKey : $routeParams.websafeStoryKey
		}).execute(
				function(resp) {
					$scope.$apply(function() {
						$scope.loading = false;
						if (resp.error) {
							// The request has
							// failed.
							var errorMessage = resp.error.message || '';
							$scope.messages = 'Failed to get the story : '
									+ $routeParams.websafeKey + ' '
									+ errorMessage;
							$scope.alertStatus = 'warning';
							$log.error($scope.messages);
						} else {
							// The request has
							// succeeded.
							$scope.alertStatus = 'success';
							$scope.story = resp.result;
						}
					});
				});
	}
});

/**
 * @ngdoc controller
 * @name RootCtrl
 * 
 * @description The root controller having a scope of the body element and
 *              methods used in the application wide such as user
 *              authentications.
 * 
 */
conferenceApp.controllers.controller('RootCtrl', function($scope, $location,
		oauth2Provider) {

	/**
	 * Returns if the viewLocation is the currently viewed page.
	 * 
	 * @param viewLocation
	 * @returns {boolean} true if viewLocation is the currently viewed page.
	 *          Returns false otherwise.
	 */
	$scope.isActive = function(viewLocation) {
		return viewLocation === $location.path();
	};

	/**
	 * Returns the OAuth2 signedIn state.
	 * 
	 * @returns {oauth2Provider.signedIn|*} true if siendIn, false otherwise.
	 */
	$scope.getSignedInState = function() {
		return oauth2Provider.signedIn;
	};

	/**
	 * Calls the OAuth2 authentication method.
	 */
	$scope.signIn = function() {
		oauth2Provider.signIn(function() {
			gapi.client.oauth2.userinfo.get().execute(function(resp) {
				$scope.$apply(function() {
					if (resp.email) {
						oauth2Provider.signedIn = true;
						$scope.alertStatus = 'success';
						$scope.rootMessages = 'Logged in with ' + resp.email;
					}
				});
			});
		});
	};

	/**
	 * Render the signInButton and restore the credential if it's stored in the
	 * cookie. (Just calling this to restore the credential from the stored
	 * cookie. So hiding the signInButton immediately after the rendering)
	 */
	$scope.initSignInButton = function() {
		gapi.signin.render('signInButton', {
			'callback' : function() {
				jQuery('#signInButton button').attr('disabled', 'true').css(
						'cursor', 'default');
				if (gapi.auth.getToken() && gapi.auth.getToken().access_token) {
					$scope.$apply(function() {
						oauth2Provider.signedIn = true;
					});
				}
			},
			'clientid' : oauth2Provider.CLIENT_ID,
			'cookiepolicy' : 'single_host_origin',
			'scope' : oauth2Provider.SCOPES
		});
	};

	/**
	 * Logs out the user.
	 */
	$scope.signOut = function() {
		oauth2Provider.signOut();
		$scope.alertStatus = 'success';
		$scope.rootMessages = 'Logged out';
	};

	/**
	 * Collapses the navbar on mobile devices.
	 */
	$scope.collapseNavbar = function() {
		angular.element(document.querySelector('.navbar-collapse'))
				.removeClass('in');
	};

});

/**
 * @ngdoc controller
 * @name OAuth2LoginModalCtrl
 * 
 * @description The controller for the modal dialog that is shown when an user
 *              needs to login to achive some functions.
 * 
 */
conferenceApp.controllers.controller('OAuth2LoginModalCtrl', function($scope,
		$modalInstance, $rootScope, oauth2Provider) {
	$scope.singInViaModal = function() {
		oauth2Provider.signIn(function() {
			gapi.client.oauth2.userinfo.get().execute(function(resp) {
				$scope.$root.$apply(function() {
					oauth2Provider.signedIn = true;
					$scope.$root.alertStatus = 'success';
					$scope.$root.rootMessages = 'Logged in with ' + resp.email;
				});

				$modalInstance.close();
			});
		});
	};
});