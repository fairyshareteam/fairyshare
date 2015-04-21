import acm.program.*;


import acm.graphics.*;
import acm.util.*;

import java.awt.Color;
import java.awt.event.*;


public class GuessTheTale extends GraphicsProgram {

	public void run() {
		
		setup();
		
		addMouseListeners();
		addTimer();
		
	}
	
	public void mouseClicked(MouseEvent e){
		for(int q=0; q<1; q++){	
		if(e.getX()>x1 & e.getX()<x1+100 & e.getY()>y1-10 & e.getY()<y1 & game==true){
				/*int a = 0;
				int b = 0;
				for(int i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)>47 && newIllustrations.charAt(i)<58) a++;
				}
				for(int i=1; i<newTales.length(); i++){
					if(newTales.charAt(i)>47 && newTales.charAt(i)<58) b++;
				}*/
				removeLabels();
				/*if(a==0) {add(spent1); break;}
				if(b==0) {add(spent2); break;}*/
				n = rgen.nextInt(1, 16);
				while(newTales.charAt(n)==32) {
					n = rgen.nextInt(1, 16);
				}
				addImageNext();
				randomCoord();
				randomAndAddLabels();
				i=-1;
				t=16;
			}
			else{
				if(e.getX()>910 & e.getX()<965 & e.getY()>615 & e.getY()<630 & game==true){
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
						if(e.getX()>910 & e.getX()<930 & e.getY()>635 & e.getY()<665 & game==true){
						if(next_b==true){
						int a = 0;
						int b = 0;
						for(int i=0; i<newIllustrations.length(); i++){
							if(newIllustrations.charAt(i)>47 && newIllustrations.charAt(i)<58) a++;
						}
						for(int i=1; i<newTales.length(); i++){
							if(newTales.charAt(i)>47 && newTales.charAt(i)<58) b++;
						}
						removeLabels();
						if(a==0) {add(spent1); break;}
						if(b==0) {add(spent2); break;}
						n = rgen.nextInt(1, 16);
						while(newTales.charAt(n)==32) {
							n = rgen.nextInt(1, 16);
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
		if(e.getX()>910 & e.getX()<965 & e.getY()>615 & e.getY()<630){
			if(fifty_fifty_b==true){
			add(line1);
			}
		}
		else{
			remove(line1);
		}
		if(e.getX()>910 & e.getX()<1015 & e.getY()>635 & e.getY()<650){
			if(one_more_frame_b==true){
			add(line2);
			}
		}
		else{
			remove(line2);
		}
		if(e.getX()>910 & e.getX()<930 & e.getY()>653 & e.getY()<665){
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
		
		this.setSize(1024, 740);
		
		add(background);
		
		fifty_fifty_l = new GLabel("Fifty-fifty");
		fifty_fifty_l.setFont("Times New Roman-14");
		fifty_fifty_l.setColor(Color.WHITE);
		add(fifty_fifty_l, 910, 624);
		
		one_more_frame_l = new GLabel("One more frame");
		one_more_frame_l.setFont("Times New Roman-14");
		one_more_frame_l.setColor(Color.WHITE);
		add(one_more_frame_l, 910, 644);
		
		next_l = new GLabel("Next");
		next_l.setFont("Times New Roman-14");
		next_l.setColor(Color.WHITE);
		add(next_l, 910, 664);
		
		line1 = new GLine(910, 628, 965, 628);
		line1.setColor(Color.WHITE);
		
		line2 = new GLine(910, 646, 1015, 646);
		line2.setColor(Color.WHITE);
		
		line3 = new GLine(910, 666, 938, 666);
		line3.setColor(Color.WHITE);
		
		n = rgen.nextInt(1, 16);
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
			int f = rgen.nextInt(1, 2); 
			if(f==1) {
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==1) break;
				}
				String image = illustrations.substring(i+2, i+7);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+7);
				illustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==2) break;
				}
				String image = illustrations.substring(i+2, i+7);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+7);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
			}
		}
		if(n==2){
			int f = rgen.nextInt(1, 2);
			if(f==1){
			int i;
			int a = 0;
			for(i=0; i<illustrations.length(); i++){
				if(illustrations.charAt(i)==59) a++;
				if(a==3) break;
			}
			String image = illustrations.substring(i+2, i+7);
			illustration = new GImage(image);
			add(illustration, 0, 0);
			CharSequence ch1 = illustrations.subSequence(i+1, i+7);
			newIllustrations = illustrations.replace(ch1, ch);
			CharSequence ch2 = tales.subSequence(n, n+1);
			newTales = tales.replace(ch2, ch);
			r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==4) break;
				}
				String image = illustrations.substring(i+2, i+7);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+7);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
				}
		}
		if(n==3){
			int f = rgen.nextInt(1, 2);
			if(f==1){
			int i;
			int a = 0;
			for(i=0; i<illustrations.length(); i++){
				if(illustrations.charAt(i)==59) a++;
				if(a==5) break;
			}
			String image = illustrations.substring(i+2, i+7);
			illustration = new GImage(image);
			add(illustration, 0, 0);
			CharSequence ch1 = illustrations.subSequence(i+1, i+7);
			newIllustrations = illustrations.replace(ch1, ch);
			CharSequence ch2 = tales.subSequence(n, n+1);
			newTales = tales.replace(ch2, ch);
			r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==6) break;
				}
				String image = illustrations.substring(i+2, i+7);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+7);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
				}
		}
		if(n==4){
			int f = rgen.nextInt(1, 2);
			if(f==1){
			int i;
			int a = 0;
			for(i=0; i<illustrations.length(); i++){
				if(illustrations.charAt(i)==59) a++;
				if(a==7) break;
			}
			String image = illustrations.substring(i+2, i+7);
			illustration = new GImage(image);
			add(illustration, 0, 0);
			CharSequence ch1 = illustrations.subSequence(i+1, i+7);
			newIllustrations = illustrations.replace(ch1, ch);
			CharSequence ch2 = tales.subSequence(n, n+1);
			newTales = tales.replace(ch2, ch);
			r++;
				}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==8) break;
				}
				String image = illustrations.substring(i+2, i+7);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+7);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
				}
		}
		if(n==5){
			int f = rgen.nextInt(1, 2); 
			if(f==1) {
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==9) break;
				}
				String image = illustrations.substring(i+2, i+7);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+7);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==10) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
			}
		}
		if(n==6){
			int f = rgen.nextInt(1, 2);
			if(f==1){
			int i;
			int a = 0;
			for(i=0; i<illustrations.length(); i++){
				if(illustrations.charAt(i)==59) a++;
				if(a==11) break;
			}
			String image = illustrations.substring(i+2, i+8);
			illustration = new GImage(image);
			add(illustration, 0, 0);
			CharSequence ch1 = illustrations.subSequence(i+1, i+8);
			newIllustrations = illustrations.replace(ch1, ch);
			CharSequence ch2 = tales.subSequence(n, n+1);
			newTales = tales.replace(ch2, ch);
			r++;
				}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==12) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
					}
		}
		if(n==7){
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==13) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==14) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch3 = illustrations.subSequence(i+10, i+16);
				newIllustrations = illustrations.replace(ch3, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
			}
		}
		if(n==8){
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==15) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==16) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
			}
		}
		if(n==9){
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==17) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==18) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+1);
				newTales = tales.replace(ch2, ch);
				r++;
			}
		}
		if(n==10){
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==19) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==20) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
		}
		if(n==11){
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==21) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==22) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
		}
		if(n==12){
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==23) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==24) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
		}
		if(n==13){
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==25) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==26) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
		}
		if(n==14){
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==27) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==28) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
		}
		if(n==15){
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==29) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==30) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
		}
		if(n==16){
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==31) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int i;
				int a = 0;
				for(i=0; i<illustrations.length(); i++){
					if(illustrations.charAt(i)==59) a++;
					if(a==32) break;
				}
				String image = illustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = illustrations.subSequence(i+1, i+8);
				newIllustrations = illustrations.replace(ch1, ch);
				CharSequence ch2 = tales.subSequence(n, n+2);
				newTales = tales.replace(ch2, ch);
				r++;
			}
		}
	}
	
	
	public void randomCoord(){
		int a = rgen.nextInt(1, 4);
		if(a==1) {x1=200; y1=637;}
		if(a==2) {x1=600; y1=637;}
		if(a==3) {x1=200; y1=657;}
		if(a==4) {x1=600; y1=657;}
		
		int b = rgen.nextInt(1, 4);
		if(b==1) {x2=200; y2=637;}
		if(b==2) {x2=600; y2=637;}
		if(b==3) {x2=200; y2=657;}
		if(b==4) {x2=600; y2=657;}
		while(b==a){
			b = rgen.nextInt(1, 4);
			if(b==1) {x2=200; y2=637;}
			if(b==2) {x2=600; y2=637;}
			if(b==3) {x2=200; y2=657;}
			if(b==4) {x2=600; y2=657;}
		}
		int c = rgen.nextInt(1, 4);
		if(c==1) {x3=200; y3=637;}
		if(c==2) {x3=600; y3=637;}
		if(c==3) {x3=200; y3=657;}
		if(c==4) {x3=600; y3=657;}
		while(c==a | c==b){
			c = rgen.nextInt(1, 4);
			if(c==1) {x3=200; y3=637;}
			if(c==2) {x3=600; y3=637;}
			if(c==3) {x3=200; y3=657;}
			if(c==4) {x3=600; y3=657;}
		}
		int d = rgen.nextInt(1, 4);
		if(d==1) {x4=200; y4=637;}
		if(d==2) {x4=600; y4=637;}
		if(d==3) {x4=200; y4=657;}
		if(d==4) {x4=600; y4=657;}
		while(d==a | d==b | d==c){
			d = rgen.nextInt(1, 4);
			if(d==1) {x4=200; y4=637;}
			if(d==2) {x4=600; y4=637;}
			if(d==3) {x4=200; y4=657;}
			if(d==4) {x4=600; y4=657;}
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

			int r = rgen.nextInt(1, 30);
			a=0;
			b=0;
			while(r==n) r = rgen.nextInt(1, 30);
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
			
			int m = rgen.nextInt(1, 30);
			while(m==n | m==r) m = rgen.nextInt(1, 30);
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
			
			int k = rgen.nextInt(1, 30);
			while(k==n | k==r | k==m) k = rgen.nextInt(1, 30);
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
		if(r==15) {newTales = tales; r=0;}
		int i;
		for(int q=0; q<1; q++){
		if(n==1) {
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2); 
			if(f==1) {
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==1) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+7);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+7);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==2) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+7);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+7);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
		}
		if(n==2) {
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
			for(i=0; i<newIllustrations.length(); i++){
				if(newIllustrations.charAt(i)==59) a++;
				if(a==3) break;
			}
			if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
			String image = newIllustrations.substring(i+2, i+7);
			illustration = new GImage(image);
			add(illustration, 0, 0);
			CharSequence ch1 = newIllustrations.subSequence(i+1, i+7);
			newIllustrations = newIllustrations.replace(ch1, ch);
			CharSequence ch2 = newTales.subSequence(n, n+1);
			newTales = newTales.replace(ch2, ch);
			r++;
			}
			if(f==2){
				int a = 0;
			for(i=0; i<newIllustrations.length(); i++){
				if(newIllustrations.charAt(i)==59) a++;
				if(a==4) break;
			}
			if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
			String image = newIllustrations.substring(i+2, i+7);
			illustration = new GImage(image);
			add(illustration, 0, 0);
			CharSequence ch1 = newIllustrations.subSequence(i+1, i+7);
			newIllustrations = newIllustrations.replace(ch1, ch);
			CharSequence ch2 = newTales.subSequence(n, n+1);
			newTales = newTales.replace(ch2, ch);
			r++;
			}
		}
		if(n==3) {
			if(newTales.charAt(n)==32  && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
			int a = 0;
			for(i=0; i<newIllustrations.length(); i++){
				if(newIllustrations.charAt(i)==59) a++;
				if(a==5) break;
			}
			if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
			String image = newIllustrations.substring(i+2, i+7);
			illustration = new GImage(image);
			add(illustration, 0, 0);
			CharSequence ch1 = newIllustrations.subSequence(i+1, i+7);
			newIllustrations = newIllustrations.replace(ch1, ch);
			CharSequence ch2 = newTales.subSequence(n, n+1);
			newTales = newTales.replace(ch2, ch);
			r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==6) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+7);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+7);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
				}
		}
		if(n==4) {
			if(newTales.charAt(n)==32  && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
			int a = 0;
			for(i=0; i<newIllustrations.length(); i++){
				if(newIllustrations.charAt(i)==59) a++;
				if(a==7) break;
			}
			if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
			String image = newIllustrations.substring(i+2, i+7);
			illustration = new GImage(image);
			add(illustration, 0, 0);
			CharSequence ch1 = newIllustrations.subSequence(i+1, i+7);
			newIllustrations = newIllustrations.replace(ch1, ch);
			CharSequence ch2 = newTales.subSequence(n, n+1);
			newTales = newTales.replace(ch2, ch);
			r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==8) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+7);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+7);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
				}
		}
		if(n==5) {
			if(newTales.charAt(n)==32  && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2); 
			if(f==1) {
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==9) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+7);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+7);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==10) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
				}
		}
		if(n==6){
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
			int a = 0;
			for(i=0; i<newIllustrations.length(); i++){
				if(newIllustrations.charAt(i)==59) a++;
				if(a==11) break;
			}
			if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
			String image = newIllustrations.substring(i+2, i+8);
			illustration = new GImage(image);
			add(illustration, 0, 0);
			CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
			newIllustrations = newIllustrations.replace(ch1, ch);
			CharSequence ch2 = newTales.subSequence(n, n+1);
			newTales = newTales.replace(ch2, ch);
			r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==12) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
				}
		}
		if(n==7){
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==13) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==14) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch3 = newIllustrations.subSequence(i+10, i+16);
				newIllustrations = newIllustrations.replace(ch3, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
		}
		if(n==8){
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==15) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==16) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
		}
		if(n==9){
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==17) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==18) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+1);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
		}
		if(n==10){
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==19) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==20) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
		}
		if(n==11){
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==21) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==22) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
		}
		if(n==12){
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==23) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==24) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
		}
		if(n==13){
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==25) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==26) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
		}
		if(n==14){
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==27) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==28) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
		}
		if(n==15){
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==29) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==30) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
		}
		if(n==16){
			if(newTales.charAt(n)==32 && OMF==false){addImageNext(); break;}
			int f = rgen.nextInt(1, 2);
			if(f==1){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==31) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
				r++;
			}
			if(f==2){
				int a = 0;
				for(i=0; i<newIllustrations.length(); i++){
					if(newIllustrations.charAt(i)==59) a++;
					if(a==32) break;
				}
				if(newIllustrations.charAt(i+2)==59) {addImageNext(); break;}
				String image = newIllustrations.substring(i+2, i+8);
				illustration = new GImage(image);
				add(illustration, 0, 0);
				CharSequence ch1 = newIllustrations.subSequence(i+1, i+8);
				newIllustrations = newIllustrations.replace(ch1, ch);
				CharSequence ch2 = newTales.subSequence(n, n+2);
				newTales = newTales.replace(ch2, ch);
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
		add(time, 50, 642);
		
		for(i=0; i<15; i++){
			if(time_go==true){
			pause(1000);
			remove(time);
			t--;
			times = new String(""+t);
			time = new GLabel(times);
			time.setFont("Times New Roman-20");
			time.setColor(Color.WHITE);
			add(time, 50, 642);
			}
			else{
				break;
				}
			}
		
		if(t==0){
			game = false;
			label1.setFont("Times New Roman-20");
			add(loss2, 0, 667);
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
		add(loss1, 420, 594);
	}
	
	

	
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public GImage illustration;
	public GImage background = new GImage("background.png");
	public GImage loss1 = new GImage("loss1.1.png");
	public GImage loss2 = new GImage("loss2.png");
	public GImage spent1 = new GImage("spent1.png");
	public GImage spent2 = new GImage("spent2.png");
	public String labels = "; Білосніжка і сім гномів; Бременські музиканти; Бридке каченя; Вовк і семеро козенят; Дюймовочка; Колобок; Красуня і чудовисько; Курочка Ряба; Попелюшка; Принцеса на горошині; Ріпка; Рукавичка; Русалонька; Снігова королева; Троє поросят; Червона шапочка; Казка про трьох ведмедів; Чахлик невмирущий; Золотий ключик, або Пригоди Буратіно; Принцеса з Іксляндрії; Казка про світлячка; Казка про яблуко; Казка про чарівне зілля; Пригода дубового листочка; Дванадцять місяців; Вушик, Горлик та Носик; Цариця фей; Хортові чобітки; Казка про велетня; Сім сестер;";
	public String illustrations = "; 1.jpg; 2.jpg; 3.jpg; 4.jpg; 5.jpg; 6.jpg; 7.jpg; 8.jpg; 9.jpg; 10.jpg; 11.jpg; 12.jpg; 13.jpg; 14.jpg; 15.jpg; 16.jpg; 17.jpg; 18.jpg; 19.jpg; 20.jpg; 21.jpg; 22.jpg; 23.jpg; 24.jpg; 25.jpg; 26.jpg; 27.jpg; 28.jpg; 29.jpg; 30.jpg; 31.jpg; 32.jpg;";
	public String newIllustrations;
	public String tales = " 12345678910111213141516";
	public String newTales;
	public String space = "  ";
	public CharSequence ch = space.subSequence(0, 1);
	public String label;
	public GLabel label1, label2, label3, label4, fifty_fifty_l, one_more_frame_l, next_l;
	public GLine line1, line2, line3;
	public int n, x1, x2, x3, x4, y1, y2, y3, y4, i, r, t;
	public boolean font,time_go, fifty_fifty_b, one_more_frame_b, next_b, game, OMF;
	public Color LIGHT_GRAY = new Color(223, 223, 223);
	

}


	
