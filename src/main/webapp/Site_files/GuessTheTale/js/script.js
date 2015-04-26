$(document).ready(function(){
$('#counter').hide();
$('#fifty-fifty').hide();
$('#illustration').hide();
$('#gameOver').hide();
$('#gameOver').attr('disabled', true);

$('#start').css('cursor', 'pointer');

$('#start').mouseenter(function(){
	$(this).css('border', '2px solid #33CCCC');
});

$('#start').mouseleave(function(){
	$(this).css('border', '2px solid #000000');
});

$('#start').click(function(){

$('#start').hide();

$('#counter').show();
$('#fifty-fifty').show();
$('#illustration').show();

var fairyTales = [
'Білосніжка і сім гномів',
'Бременські музиканти',
'Бридке каченя',
'Вовк і семеро козенят',
'Дюймовочка',
'Колобок',
'Красуня і чудовисько',
'Курочка Ряба',
'Попелюшка',
'Принцеса на горошині',
'Ріпка',
'Рукавичка',
'Русалонька',
'Снігова королева',
'Троє поросят',
'Червона шапочка',
'Чахлик невмирущий',
'Буратіно',
'Принцеса з Іксляндрії',
'Казка про світлячка',
'Казка про яблуко',
'Казка про чарівне зілля',
'Дванадцять місяців',
'Вушик, Горлик та Носик',
'Цариця фей',
'Хортові чобітки',
'Казка про велетня',
'Сім сестер'
];

var images = $('.guess_item').length;
var orderArr = [];
var e = 0;
var counter=0;
document.getElementById('counter').innerHTML = counter; 
function main(){
	//написать, что делает все блоки
	if($('.images').hasClass('round_1')){
		$('.images').removeClass('round_1').addClass('round_2');
	}else if($('.images').hasClass('round_2')){
		$('.images').removeClass('round_2').addClass('round_1');
	}else{
		$('.images').addClass('round_1');
	}

	for(var i=1;i<=images;i++){
	  orderArr.push(i); 
	}
	console.log(orderArr);

	shuffle(orderArr);
	console.log(orderArr);

	console.log('а сейчас '+ orderArr[e]);
}

main();

var a = [];
var maxFairy = fairyTales.length - 1;

function randomWrong(){
	for(var c = 0; c < 3; c++){
		randomNum = getRandomInt(0, maxFairy);
		if(c==0){
			while(randomNum == orderArr[e]){
				randomNum = getRandomInt(0, maxFairy);
			}
			a.push(randomNum);
		}else{
			var aLength = a.length;
			for(var p = 0; p < 1; p++){
				while(randomNum == orderArr[e] || randomNum == a[p]){
					randomNum = getRandomInt(0, maxFairy);
				}
				a.push(randomNum);
			}
		}
	}
	console.log(a);

	var t = 0;
	$('.guess_item[rel="'+orderArr[e]+'"] .wrong').each(function(){
		if(t == 3){
			t = 0;
			var fairyLoop = a[t];
			$(this).text(fairyTales[fairyLoop]);
		}else{
			var fairyLoop = a[t];
			$(this).text(fairyTales[fairyLoop]);
			t++;
		}
	});
}

randomWrong();


$('.guess_item[rel="'+orderArr[e]+'"]').addClass('active');
$('.guess_item[rel="'+orderArr[e]+'"] button').shuffle();

$('.guess_item .right').click(function(){
	if(e < images-1){
		$(this).parents('.guess_item').removeClass('active');
		e++;
		$('.guess_item[rel="'+orderArr[e]+'"]').addClass('active');
		a = [];
		randomWrong();
		$('.guess_item[rel="'+orderArr[e]+'"] button').shuffle();
	}else{
		e = 0;
		main();
	}
});

$('.right').click(function(){
	counter++;
	document.getElementById('counter').innerHTML = counter; 
});

function shuffle(o){
    for(var j, x, i = o.length; i; j = Math.floor(Math.random() * i), x = o[--i], o[i] = o[j], o[j] = x);
    return o;
};

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

$('button').css('cursor', 'pointer');

$('button').mouseenter(function(){
	$(this).css('border', '2px solid #33CCCC');
});

$('button').mouseleave(function(){
	$(this).css('border', '2px solid #000000');
});

$('.wrong').click(function(){
	$('.active button:nth-child(1)').attr('disabled', true);
	$('.active button:nth-child(2)').attr('disabled', true);
	$('.active button:nth-child(3)').attr('disabled', true);
	$('.active button:nth-child(4)').attr('disabled', true);
	$('#fifty-fifty').attr('disabled', true);
	$('#illustration').attr('disabled', true);
	$('button').css('cursor', 'auto');
	$('button').css('border', '2px solid #000000');
	$('.right').css('border', '2px solid #33CCCC');
	$('#gameOver').show();
});

$('#fifty-fifty').click(function(){
	$('.active button:nth-child(2)').css('border', '2px solid #CCCCCC');
	$('.active button:nth-child(2)').attr('disabled', true);
	$('.active button:nth-child(2)').css('cursor', 'auto');
	$('.active button:nth-child(4)').css('border', '2px solid #CCCCCC');
	$('.active button:nth-child(4)').attr('disabled', true);
	$('.active button:nth-child(4)').css('cursor', 'auto');
	if($('.active button:nth-child(2)').hasClass('right')){
		$('.active button:nth-child(2)').css('border', '2px solid #000000');
		$('.active button:nth-child(2)').attr('disabled', false);
		$('.active button:nth-child(2)').css('cursor', 'pointer');
		$('.active button:nth-child(3)').css('border', '2px solid #CCCCCC');
		$('.active button:nth-child(3)').attr('disabled', true);
		$('.active button:nth-child(3)').css('cursor', 'auto');
	}else{
		if($('.active button:nth-child(4)').hasClass('right')){
			$('.active button:nth-child(4)').css('border', '2px solid #000000');
			$('.active button:nth-child(4)').attr('disabled', false);
			$('.active button:nth-child(4)').css('cursor', 'pointer');
			$('.active button:nth-child(3)').css('border', '2px solid #CCCCCC');
			$('.active button:nth-child(3)').attr('disabled', true);
			$('.active button:nth-child(3)').css('cursor', 'auto');
		}
	}
	$(this).css('border', '2px solid #CCCCCC');
	$(this).attr('disabled', true);
	$(this).css('cursor', 'auto');
});
$('#illustration').click(function(){
	if($('.active img:nth-of-type(2)').css('display')=='none') {
		$('.active img:nth-of-type(2)').show();
		$('.active img:nth-of-type(1)').hide();
	}else{
		if($('.active img:nth-of-type(1)').css('display')=='none') {
		$('.active img:nth-of-type(1)').show();
		$('.active img:nth-of-type(2)').hide();
	}
	}
	$(this).css('border', '2px solid #CCCCCC');
	$(this).attr('disabled', true);
	$(this).css('cursor', 'auto');
});
});
});