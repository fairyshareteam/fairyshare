import acm.program.*;


import acm.graphics.*;
import acm.util.*;

import java.awt.Color;
import java.awt.event.*;


public class FrameGame extends GraphicsProgram{

	public void run() {
		
		setup();
		
		addMouseListeners();
		addTimer();
		
	}
	
	public void mouseClicked(MouseEvent e){
		for(int q=0; q<1; q++){	
		if(e.getX()>x1 & e.getX()<x1+100 & e.getY()>y1-10 & e.getY()<y1 & game==true){
				int a = 0;
				int b = 0;
				for(int i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)>47 && newImages.charAt(i)<58) a++;
				}
				for(int i=1; i<newMovies.length(); i++){
					if(newMovies.charAt(i)>47 && newMovies.charAt(i)<58) b++;
				}
				removeLabels();
				if(a==0) {add(spent1); break;}
				if(b==0) {add(spent2); break;}
				n = rgen.nextInt(1, 10);
				while(newMovies.charAt(n)==32) {
					n = rgen.nextInt(1, 10);
				}
				addImageNext();
				randomCoord();
				randomAndAddLabels();
				i=-1;
				t=16;
			}
			else{
				if(e.getX()>910 & e.getX()<965 & e.getY()>448 & e.getY()<463 & game==true){
				if(fifty_fifty_b==true){
				remove(label2);
				remove(label4);
				fifty_fifty_l.setColor(Color.LIGHT_GRAY);
				remove(line1);
				fifty_fifty_b = false;
					}
				}
				else{
					if(e.getX()>910 & e.getX()<1015 & e.getY()>468 & e.getY()<483 & game==true){
						if(one_more_frame_b==true){
						OMF = true;
						addImageNext();
						OMF = false;
						one_more_frame_l.setColor(Color.LIGHT_GRAY);
						remove(line2);
						one_more_frame_b = false;
						}
					}
					else{
						if(e.getX()>910 & e.getX()<930 & e.getY()>486 & e.getY()<498 & game==true){
						if(next_b==true){
						int a = 0;
						int b = 0;
						for(int i=0; i<newImages.length(); i++){
							if(newImages.charAt(i)>47 && newImages.charAt(i)<58) a++;
						}
						for(int i=1; i<newMovies.length(); i++){
							if(newMovies.charAt(i)>47 && newMovies.charAt(i)<58) b++;
						}
						removeLabels();
						if(a==0) {add(spent1); break;}
						if(b==0) {add(spent2); break;}
						n = rgen.nextInt(1, 10);
						while(newMovies.charAt(n)==32) {
							n = rgen.nextInt(1, 10);
						}
						addImageNext();
						randomCoord();
						randomAndAddLabels();
						i=-1;
						t=16;
						next_l.setColor(Color.LIGHT_GRAY);
						remove(line3);
						next_b = false;
						}
					}
					else{
						if(e.getX()>x2 & e.getX()<x2+100 & e.getY()>y2-10 & e.getY()<y2){
						gameOver();
						}
						else{
							if(e.getX()>x3 & e.getX()<x3+100 & e.getY()>y3-10 & e.getY()<y3){
								gameOver();
							}
							else{
								if(e.getX()>x4 & e.getX()<x4+100 & e.getY()>y4-10 & e.getY()<y4){
									gameOver();
								}
							}
						}
					}
				}
			}
		}
	}
}
	
	
	
	public void mouseMoved(MouseEvent e){
		if(game==true & font==true){
		if(e.getX()>x1 & e.getX()<x1+100 & e.getY()>y1-10 & e.getY()<y1){
			label1.setFont("Times New Roman-15");
		}
		else{
			label1.setFont("Times New Roman");
		}
		if(e.getX()>x2 & e.getX()<x2+150 & e.getY()>y2-10 & e.getY()<y2){
			label2.setFont("Times New Roman-15");
		}
		else{
			label2.setFont("Times New Roman");
		}
		if(e.getX()>x3 & e.getX()<x3+150 & e.getY()>y3-10 & e.getY()<y3){
			label3.setFont("Times New Roman-15");
		}
		else{
			label3.setFont("Times New Roman");
		}
		if(e.getX()>x4 & e.getX()<x4+150 & e.getY()>y4-10 & e.getY()<y4){
			label4.setFont("Times New Roman-15");
		}
		else{
			label4.setFont("Times New Roman");
		}
		if(e.getX()>910 & e.getX()<965 & e.getY()>448 & e.getY()<463){
			if(fifty_fifty_b==true){
			add(line1);
			}
		}
		else{
			remove(line1);
		}
		if(e.getX()>910 & e.getX()<1015 & e.getY()>468 & e.getY()<483){
			if(one_more_frame_b==true){
			add(line2);
			}
		}
		else{
			remove(line2);
		}
		if(e.getX()>910 & e.getX()<930 & e.getY()>486 & e.getY()<498){
			if(next_b==true){
			add(line3);
			}
		}
		else{
			remove(line3);
		}
	}
}
	
	
	public void setup(){
		
		this.setSize(1024, 573);
		
		add(background);
		
		fifty_fifty_l = new GLabel("Fifty-fifty");
		fifty_fifty_l.setFont("Times New Roman-14");
		fifty_fifty_l.setColor(Color.WHITE);
		add(fifty_fifty_l, 910, 457);
		
		one_more_frame_l = new GLabel("One more frame");
		one_more_frame_l.setFont("Times New Roman-14");
		one_more_frame_l.setColor(Color.WHITE);
		add(one_more_frame_l, 910, 477);
		
		next_l = new GLabel("Next");
		next_l.setFont("Times New Roman-14");
		next_l.setColor(Color.WHITE);
		add(next_l, 910, 497);
		
		line1 = new GLine(910, 461, 965, 461);
		line1.setColor(Color.WHITE);
		
		line2 = new GLine(910, 479, 1015, 479);
		line2.setColor(Color.WHITE);
		
		line3 = new GLine(910, 499, 938, 499);
		line3.setColor(Color.WHITE);
		
		n = rgen.nextInt(1, 10);
		font = true;
		time_go = true;
		fifty_fifty_b = true;
		one_more_frame_b = true;
		OMF = false;
		next_b = true;
		game = true;
		addImage();
		randomCoord();
		randomAndAddLabels();
	
		
	}
	
	
	public void addImage(){
		
		r=0;
		
		if(n==1){
			int f = rgen.nextInt(1, 8); 
			if(f==1) {
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==1) break;
				}
				String image = images.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+7);
				images = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==2) break;
				}
				String image = images.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+7);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==3){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==3) break;
				}
				String image = images.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+7);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==4){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==4) break;
				}
				String image = images.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+7);
				newImages = images.replace(ch1, ch);
				CharSequence ch3 = images.subSequence(i+9, i+15);
				newImages = images.replace(ch3, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==5){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==5) break;
				}
				String image = images.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+7);
				newImages = images.replace(ch1, ch);
				CharSequence ch3 = images.subSequence(i-6, i);
				newImages = images.replace(ch3, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==6){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==6) break;
				}
				String image = images.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+7);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==7){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==7) break;
				}
				String image = images.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+7);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==8){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==8) break;
				}
				String image = images.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+7);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
		}
		if(n==2){
			int f = rgen.nextInt(1, 6);
			if(f==1){
			int i;
			int a = 0;
			for(i=0; i<images.length(); i++){
				if(images.charAt(i)==59) a++;
				if(a==9) break;
			}
			String image = images.substring(i+2, i+7);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = images.subSequence(i+1, i+7);
			newImages = images.replace(ch1, ch);
			CharSequence ch2 = movies.subSequence(n, n+1);
			newMovies = movies.replace(ch2, ch);
			r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==10) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
			if(f==3){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==11) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
			if(f==4){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==12) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
			if(f==5){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==13) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
			if(f==6){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==14) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
		}
		if(n==3){
			int f = rgen.nextInt(1, 6);
			if(f==1){
			int i;
			int a = 0;
			for(i=0; i<images.length(); i++){
				if(images.charAt(i)==59) a++;
				if(a==15) break;
			}
			String image = images.substring(i+2, i+8);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = images.subSequence(i+1, i+8);
			newImages = images.replace(ch1, ch);
			CharSequence ch2 = movies.subSequence(n, n+1);
			newMovies = movies.replace(ch2, ch);
			r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==16) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
			if(f==3){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==17) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
			if(f==4){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==18) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
			if(f==5){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==19) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
			if(f==6){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==20) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
		}
		if(n==4){
			int f = rgen.nextInt(1, 4);
			if(f==1){
			int i;
			int a = 0;
			for(i=0; i<images.length(); i++){
				if(images.charAt(i)==59) a++;
				if(a==21) break;
			}
			String image = images.substring(i+2, i+8);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = images.subSequence(i+1, i+8);
			newImages = images.replace(ch1, ch);
			CharSequence ch2 = movies.subSequence(n, n+1);
			newMovies = movies.replace(ch2, ch);
			r++;
				}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==22) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
			if(f==3){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==23) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
			if(f==4){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==24) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
				}
		}
		if(n==5){
			int f = rgen.nextInt(1, 2); 
			if(f==1) {
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==25) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==26) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
		}
		if(n==6){
			int f = rgen.nextInt(1, 13);
			if(f==1){
			int i;
			int a = 0;
			for(i=0; i<images.length(); i++){
				if(images.charAt(i)==59) a++;
				if(a==27) break;
			}
			String image = images.substring(i+2, i+8);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = images.subSequence(i+1, i+8);
			newImages = images.replace(ch1, ch);
			CharSequence ch2 = movies.subSequence(n, n+1);
			newMovies = movies.replace(ch2, ch);
			r++;
				}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==28) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
					}
			if(f==3){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==29) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
					}
			if(f==4){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==30) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
					}
			if(f==5){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==31) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
					}
			if(f==6){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==32) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
					}
			if(f==7){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==33) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
					}
			if(f==8){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==34) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
					}
			if(f==9){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==35) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
					}
			if(f==10){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==36) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
					}
			if(f==11){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==37) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
					}
			if(f==12){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==38) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
					}
			if(f==13){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==39) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
					}
		}
		if(n==7){
			int f = rgen.nextInt(1, 8);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==40) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==41) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch3 = images.subSequence(i+10, i+16);
				newImages = images.replace(ch3, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==3){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==42) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch3 = images.subSequence(i-7, i);
				newImages = images.replace(ch3, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==4){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==43) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==5){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==44) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==6){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==45) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==7){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==46) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==8){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==47) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
		}
		if(n==8){
			int f = rgen.nextInt(1, 3);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==48) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==49) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==3){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==50) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
		}
		if(n==9){
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==51) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==52) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+1);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
		}
		if(n==10){
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==53) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+2);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<images.length(); i++){
					if(images.charAt(i)==59) a++;
					if(a==54) break;
				}
				String image = images.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = images.subSequence(i+1, i+8);
				newImages = images.replace(ch1, ch);
				CharSequence ch2 = movies.subSequence(n, n+2);
				newMovies = movies.replace(ch2, ch);
				r++;
			}
		}
	}
	
	
	public void randomCoord(){
		int a = rgen.nextInt(1, 4);
		if(a==1) {x1=200; y1=470;}
		if(a==2) {x1=600; y1=470;}
		if(a==3) {x1=200; y1=490;}
		if(a==4) {x1=600; y1=490;}
		
		int b = rgen.nextInt(1, 4);
		if(b==1) {x2=200; y2=470;}
		if(b==2) {x2=600; y2=470;}
		if(b==3) {x2=200; y2=490;}
		if(b==4) {x2=600; y2=490;}
		while(b==a){
			b = rgen.nextInt(1, 4);
			if(b==1) {x2=200; y2=470;}
			if(b==2) {x2=600; y2=470;}
			if(b==3) {x2=200; y2=490;}
			if(b==4) {x2=600; y2=490;}
		}
		int c = rgen.nextInt(1, 4);
		if(c==1) {x3=200; y3=470;}
		if(c==2) {x3=600; y3=470;}
		if(c==3) {x3=200; y3=490;}
		if(c==4) {x3=600; y3=490;}
		while(c==a | c==b){
			c = rgen.nextInt(1, 4);
			if(c==1) {x3=200; y3=470;}
			if(c==2) {x3=600; y3=470;}
			if(c==3) {x3=200; y3=490;}
			if(c==4) {x3=600; y3=490;}
		}
		int d = rgen.nextInt(1, 4);
		if(d==1) {x4=200; y4=470;}
		if(d==2) {y4=470; x4=600;}
		if(d==3) {x4=200; y4=490;}
		if(d==4) {x4=600; y4=490;}
		while(d==a | d==b | d==c){
			d = rgen.nextInt(1, 4);
			if(d==1) {x4=200; y4=470;}
			if(d==2) {x4=600; y4=470;}
			if(d==3) {x4=200; y4=490;}
			if(d==4) {x4=600; y4=490;}
		}
	}
	
	
	
	
	public void randomAndAddLabels(){
			int i;
			int a = 0;
			int b = 0;
			
			for(i=0; i<labels.length(); i++){
				if(labels.charAt(i)==59) a++;
				if(a==n) break;
			}
			for(int d=i+1; d<=labels.length(); d++){
				if(labels.charAt(d)!=59) b++;
				else break;
			}
			label = labels.substring(i+1, i+1+b);
			label1 = new GLabel(label);
			label1.setColor(Color.WHITE);
			add(label1, x1, y1);

			int r = rgen.nextInt(1, 24);
			a=0;
			b=0;
			while(r==n) r = rgen.nextInt(1, 24);
			for(i=0; i<labels.length(); i++){
				if(labels.charAt(i)==59) a++;
				if(a==r) break;
			}
			for(int d=i+1; d<=labels.length(); d++){
				if(labels.charAt(d)!=59) b++;
				else break;
			}
			label = labels.substring(i+1, i+1+b);
			label2 = new GLabel(label);
			label2.setColor(Color.WHITE);
			add(label2, x2, y2);
			
			int m = rgen.nextInt(1, 24);
			while(m==n | m==r) m = rgen.nextInt(1, 24);
			a = 0;
			b = 0;
			for(i=0; i<labels.length(); i++){
				if(labels.charAt(i)==59) a++;
				if(a==m) break;
			}
			for(int d=i+1; d<=labels.length(); d++){
				if(labels.charAt(d)!=59) b++;
				else break;
			}
			label = labels.substring(i+1, i+1+b);
			label3 = new GLabel(label);
			label3.setColor(Color.WHITE);
			add(label3, x3, y3);
			
			int k = rgen.nextInt(1, 24);
			while(k==n | k==r | k==m) k = rgen.nextInt(1, 24);
			a = 0;
			b = 0;
			for(i=0; i<labels.length(); i++){
				if(labels.charAt(i)==59) a++;
				if(a==k) break;
			}
			for(int d=i+1; d<=labels.length(); d++){
				if(labels.charAt(d)!=59) b++;
				else break;
			}
			label = labels.substring(i+1, i+1+b);
			label4 = new GLabel(label);
			label4.setColor(Color.WHITE);
			add(label4, x4, y4);
			
			}
	
	
	
	
	
	
	public void addImageNext(){
		if(r==9) {newMovies = movies; r=0;}
		int i;
		for(int q=0; q<1; q++){
		if(n==1){
			if(newMovies.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 8); 
			if(f==1) {
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==1) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+7);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==2) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+7);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==3) {
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==3) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+7);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==4) {
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==4) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+7);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch3 = newImages.subSequence(i+9, i+15);
				newImages = newImages.replace(ch3, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==5) {
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==5) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+7);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch3 = newImages.subSequence(i-6, i);
				newImages = newImages.replace(ch3, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==6) {
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==6) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+7);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==7) {
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==7) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+7);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==8) {
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==8) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+7);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+7);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
		}
		if(n==2) {
			if(newMovies.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 6);
			if(f==1){
				int a = 0;
			for(i=0; i<newImages.length(); i++){
				if(newImages.charAt(i)==59) a++;
				if(a==9) break;
			}
			if(newImages.charAt(i+2)==59) {addImageNext(); break;}
			String image = newImages.substring(i+2, i+7);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = newImages.subSequence(i+1, i+7);
			newImages = newImages.replace(ch1, ch);
			CharSequence ch2 = newMovies.subSequence(n, n+1);
			newMovies = newMovies.replace(ch2, ch);
			r++;
			}
			if(f==2){
				int a = 0;
			for(i=0; i<newImages.length(); i++){
				if(newImages.charAt(i)==59) a++;
				if(a==10) break;
			}
			if(newImages.charAt(i+2)==59) {addImageNext(); break;}
			String image = newImages.substring(i+2, i+8);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = newImages.subSequence(i+1, i+8);
			newImages = newImages.replace(ch1, ch);
			CharSequence ch2 = newMovies.subSequence(n, n+1);
			newMovies = newMovies.replace(ch2, ch);
			r++;
			}
			if(f==3){
				int a = 0;
			for(i=0; i<newImages.length(); i++){
				if(newImages.charAt(i)==59) a++;
				if(a==11) break;
			}
			if(newImages.charAt(i+2)==59) {addImageNext(); break;}
			String image = newImages.substring(i+2, i+8);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = newImages.subSequence(i+1, i+8);
			newImages = newImages.replace(ch1, ch);
			CharSequence ch2 = newMovies.subSequence(n, n+1);
			newMovies = newMovies.replace(ch2, ch);
			r++;
			}
			if(f==4){
				int a = 0;
			for(i=0; i<newImages.length(); i++){
				if(newImages.charAt(i)==59) a++;
				if(a==12) break;
			}
			if(newImages.charAt(i+2)==59) {addImageNext(); break;}
			String image = newImages.substring(i+2, i+8);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = newImages.subSequence(i+1, i+8);
			newImages = newImages.replace(ch1, ch);
			CharSequence ch2 = newMovies.subSequence(n, n+1);
			newMovies = newMovies.replace(ch2, ch);
			r++;
			}
			if(f==5){
				int a = 0;
			for(i=0; i<newImages.length(); i++){
				if(newImages.charAt(i)==59) a++;
				if(a==13) break;
			}
			if(newImages.charAt(i+2)==59) {addImageNext(); break;}
			String image = newImages.substring(i+2, i+8);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = newImages.subSequence(i+1, i+8);
			newImages = newImages.replace(ch1, ch);
			CharSequence ch2 = newMovies.subSequence(n, n+1);
			newMovies = newMovies.replace(ch2, ch);
			r++;
			}
			if(f==6){
				int a = 0;
			for(i=0; i<newImages.length(); i++){
				if(newImages.charAt(i)==59) a++;
				if(a==14) break;
			}
			if(newImages.charAt(i+2)==59) {addImageNext(); break;}
			String image = newImages.substring(i+2, i+8);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = newImages.subSequence(i+1, i+8);
			newImages = newImages.replace(ch1, ch);
			CharSequence ch2 = newMovies.subSequence(n, n+1);
			newMovies = newMovies.replace(ch2, ch);
			r++;
			}
		}
		if(n==3) {
			if(newMovies.charAt(n)==32  && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 6);
			if(f==1){
			int a = 0;
			for(i=0; i<newImages.length(); i++){
				if(newImages.charAt(i)==59) a++;
				if(a==15) break;
			}
			if(newImages.charAt(i+2)==59) {addImageNext(); break;}
			String image = newImages.substring(i+2, i+8);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = newImages.subSequence(i+1, i+8);
			newImages = newImages.replace(ch1, ch);
			CharSequence ch2 = newMovies.subSequence(n, n+1);
			newMovies = newMovies.replace(ch2, ch);
			r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==16) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==3){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==17) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==4){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==18) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==5){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==19) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==6){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==20) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
		}
		if(n==4) {
			if(newMovies.charAt(n)==32  && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 4);
			if(f==1){
			int a = 0;
			for(i=0; i<newImages.length(); i++){
				if(newImages.charAt(i)==59) a++;
				if(a==21) break;
			}
			if(newImages.charAt(i+2)==59) {addImageNext(); break;}
			String image = newImages.substring(i+2, i+8);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = newImages.subSequence(i+1, i+8);
			newImages = newImages.replace(ch1, ch);
			CharSequence ch2 = newMovies.subSequence(n, n+1);
			newMovies = newMovies.replace(ch2, ch);
			r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==22) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==3){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==23) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==4){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==24) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
		}
		if(n==5) {
			if(newMovies.charAt(n)==32  && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2); 
			if(f==1) {
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==25) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==26) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
		}
		if(n==6){
			if(newMovies.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 13);
			if(f==1){
			int a = 0;
			for(i=0; i<newImages.length(); i++){
				if(newImages.charAt(i)==59) a++;
				if(a==27) break;
			}
			if(newImages.charAt(i+2)==59) {addImageNext(); break;}
			String image = newImages.substring(i+2, i+8);
			frame = new GImage(image);
			add(frame, 0, 0);
			CharSequence ch1 = newImages.subSequence(i+1, i+8);
			newImages = newImages.replace(ch1, ch);
			CharSequence ch2 = newMovies.subSequence(n, n+1);
			newMovies = newMovies.replace(ch2, ch);
			r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==28) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==3){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==29) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==4){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==30) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==5){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==31) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==6){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==32) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==7){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==33) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==8){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==34) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==9){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==35) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==10){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==36) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==11){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==37) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==12){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==38) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
			if(f==13){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==39) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
				}
		}
		if(n==7){
			if(newMovies.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 8);
			if(f==1){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==40) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==41) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch3 = newImages.subSequence(i+10, i+16);
				newImages = newImages.replace(ch3, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==3){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==42) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch3 = newImages.subSequence(i-7, i);
				newImages = newImages.replace(ch3, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==4){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==43) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==5){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==44) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==6){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==45) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==7){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==46) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==8){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==47) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
		}
		if(n==8){
			if(newMovies.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 3);
			if(f==1){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==48) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==49) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==3){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==50) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
		}
		if(n==9){
			if(newMovies.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==51) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==52) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+1);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
		}
		if(n==10){
			if(newMovies.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==53) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+2);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newImages.length(); i++){
					if(newImages.charAt(i)==59) a++;
					if(a==54) break;
				}
				if(newImages.charAt(i+2)==59) {addImageNext(); break;}
				String image = newImages.substring(i+2, i+8);
				frame = new GImage(image);
				add(frame, 0, 0);
				CharSequence ch1 = newImages.subSequence(i+1, i+8);
				newImages = newImages.replace(ch1, ch);
				CharSequence ch2 = newMovies.subSequence(n, n+2);
				newMovies = newMovies.replace(ch2, ch);
				r++;
			}
		}
	}
}
	
	
	public void addTimer(){
		t = 15;
		String times = new String(""+t);
		GLabel time = new GLabel(times);
		time.setFont("Times New Roman-20");
		time.setColor(Color.WHITE);
		add(time, 50, 475);
		
		for(i=0; i<15; i++){
			if(time_go==true){
			pause(1000);
			remove(time);
			t--;
			times = new String(""+t);
			time = new GLabel(times);
			time.setFont("Times New Roman-20");
			time.setColor(Color.WHITE);
			add(time, 50, 475);
			}
			else{
				break;
				}
			}
		
		if(t==0){
			game = false;
			label1.setFont("Times New Roman-20");
			add(loss2, 0, 500);
			}
		}
	
	
	
	public void removeLabels(){
		remove(label1);
		remove(label2);
		remove(label3);
		remove(label4);
	}
	
	public void gameOver(){
		game = false;
		font = false;
		time_go = false;
		label1.setFont("Times New Roman-20");
		add(loss1, 0, 500);
	}
	
	

	
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public GImage frame;
	public GImage background = new GImage("background.png");
	public GImage loss1 = new GImage("loss1.png");
	public GImage loss2 = new GImage("loss2.png");
	public GImage spent1 = new GImage("spent1.png");
	public GImage spent2 = new GImage("spent2.png");
	public String labels = "; Inception; The Dark Knight; Fight Club; Shindler's List; The Dark Knight Rises; Memento; The Prestige; Pulp Fiction; Lock, Stock and Two Smoking Barrels; Se7en; The Departed; The Shawshank Redemption; The Godfather; The Matrix; Reservoir Dogs; Inglourious Basterds; Forrest Gump; Back to the Future; Gladiator; Goodfellas; Sherlock Holmes; The Lord of the Rings: The Fellowship of the Ring; The Lord of the Rings: The Two Towers; The Lord of the Rings: The Return of the King;";
	public String images = "; 1.jpg; 2.jpg; 3.jpg; 4.jpg; 5.jpg; 6.jpg; 7.jpg; 8.jpg; 9.jpg; 10.jpg; 11.jpg; 12.jpg; 13.jpg; 14.jpg; 15.jpg; 16.jpg; 17.jpg; 18.jpg; 19.jpg; 20.jpg; 21.jpg; 22.jpg; 23.jpg; 24.jpg; 25.jpg; 26.jpg; 27.jpg; 28.jpg; 29.jpg; 30.jpg; 31.jpg; 32.jpg; 33.jpg; 34.jpg; 35.jpg; 36.jpg; 37.jpg; 38.jpg; 39.jpg; 40.jpg; 41.jpg; 42.jpg; 43.jpg; 44.jpg; 45.jpg; 46.jpg; 47.jpg; 48.jpg; 49.jpg; 50.jpg; 51.jpg; 52.jpg; 53.jpg; 54.jpg;";
	public String newImages;
	public String movies = " 12345678910";
	public String newMovies;
	public String space = "  ";
	public CharSequence ch = space.subSequence(0, 1);
	public String label;
	public GLabel label1, label2, label3, label4, fifty_fifty_l, one_more_frame_l, next_l;
	public GLine line1, line2, line3;
	public int n, x1, x2, x3, x4, y1, y2, y3, y4, i, r, t;
	public boolean font,time_go, fifty_fifty_b, one_more_frame_b, next_b, game, OMF;
	public Color LIGHT_GRAY = new Color(223, 223, 223);
	

}


	
