package graphic;

import javax.swing.JComponent;    
import javax.swing.JFrame;    

import java.awt.Color;    
import java.awt.Container;    
import java.awt.Dimension;    
import java.awt.Graphics;  
import java.awt.Point;  

      /*-------------------------------------------------------------------*/
      /*          ATTENTION : SWING N'EST PAS THREAD-SAFE                  */
      /*-------------------------------------------------------------------*/
    
/*---------------------------------------------------------------------------------*/

class ALine extends JComponent {
	Color color;
	int x1, y1, x2, y2;

	public ALine(int x1, int y1, int x2, int y2, String color) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		setOpaque(false);
		try {
			this.color = MyColor.parseMyColor(color);
		}
		catch (ColorNotFoundException e) {
			System.out.println ("Invalid color. Black used instead");
			this.color = Color.black;
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
	}  

 }   

/*---------------------------------------------------------------------------------*/

class APoint extends ALine {
	public APoint (int x1, int y1, String color) {
		super(x1, y1, x1, y1, color);
	}
}

/*---------------------------------------------------------------------------------*/
/*---------------------------------------------------------------------------------*/
    
public class Window extends JFrame {
	private int largeur, hauteur;
	private Container cp;

/*-----------------------------  LES CONSTRUCTEURS  ------------------------------*/
	 
	private void setParametersW(int width, int height) {
		largeur = width;
		hauteur = height;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize (new Dimension (width, height));
		cp = this.getContentPane();
	}

	/**
	 * Creates a window with dimensions width x height, a title title
	 * and no background color
	 */
	public Window(int width, int height, String title) {
		//Create and set up the window.
		super(title);
		setParametersW(width, height);

		//Display the window.
		setVisible(true);
   }

	/**
	 * Creates a window with dimensions width x height, a title title
	 * and a background color color
	 */
	public Window(int width, int height, String title, String color) {
		super(title);
		setParametersW(width, height);
		fill(color);
	}

 
 /*-------------------------   REMPLIR LA FENETRE   ------------------------*/

	/**
	 * Fills the background of the window with color color
	 */
   public void fill (String color) {
		try {
			cp.setBackground(MyColor.parseMyColor(color));
		}
		catch (ColorNotFoundException e) {
			System.out.println ("Invalid background color. White used instead");
			cp.setBackground(Color.white);
		}
		setVisible(true);
   }

/*---------------------------   TRACER UN POINT   --------------------------*/

	private void drawPoint (int x, int y, String color) {
		try { 
			if ( x < 0 || x >= largeur) {
				throw new IndexOutOfBoundsException("Invalid abscissa : pixel out");
			}
			if ( y < 0 || y >= hauteur) {
				throw new IndexOutOfBoundsException("Invalid ordinate : pixel out");
			}
			synchronized(cp) {
				APoint pt = new APoint(x, y, color);
				add(pt);
				pt.setVisible(true);
			}
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println( e.getMessage() );
		}
	}
		
	private void drawPoint (int x, int y) {
		drawPoint(x, y, "black");
	}

	/**
	 * Draws point pt with color color
	 */    
	public void drawPoint (Point pt, String color) {
		drawPoint(pt.x, pt.y, color);
	}

	/**
	 * Draws point pt in black
	 */    
	public void drawPoint (Point pt) {
		drawPoint(pt.x, pt.y, "black");
	}
	
  
/*--------------------------   TRACER UNE LIGNE   --------------------------*/


	/**
	 * Draws a line of color color between points (x1, y1) and (x2, y2)
	 */    
	private void drawLine(int x1, int y1, int x2, int y2, String color) {
		try { 
			if ( x1 < 0 || x1 >= largeur || x2 < 0 || x2 >= largeur) {
				throw new IndexOutOfBoundsException("Invalid abscissa : pixel out");
			}
			if ( y1 < 0 || y1 >= hauteur || y2 < 0 || y2 >= hauteur) {
				throw new IndexOutOfBoundsException("Invalid ordinate : pixel out");
			}
			synchronized(cp) {
				ALine l = new ALine(x1, y1, x2, y2, color);
				add(l);
				setVisible(true);
			}
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println( e.getMessage() );
		}
	}

	/**
	 * Draws a black line between points (x1, y1) and (x2, y2)
	 */  
	private void drawLine(int x1, int y1, int x2, int y2) {
		drawLine(x1, y1, x2, y2, "black");
	}
	
 	/**
	 * Draws a line of color color between points pt1 and pt2
	 */  
	 public void drawLine (Point pt1, Point pt2, String color) {
	 	drawLine(pt1.x, pt1.y, pt2.x, pt2.y, color);
	 }
	 
 	/**
	 * Draws a black line between points pt1 and pt2
	 */  
	 public void drawLine (Point pt1, Point pt2) {
	 	drawLine(pt1.x, pt1.y, pt2.x, pt2.y, "black");
	 }

/*--------------------   TRACER UNE LIGNE POINT A POINT  -------------------*/
   
	/**
	 * Plots a line of color color from point (x1, y1) to point (x2, y2)
	 */  
	private void plotLine (int x1, int y1, int x2, int y2, String color) {
		/* intervalle entre le trace de 2 points. Pour une meilleure visualisation du parallelisme */
		final int DELAI = 10;	
		
		int x, y, Xincr, Yincr;
		
		try { 
			if ( x1 < 0 || x1 >= largeur || x2 < 0 || x2 >= largeur ) {
				throw new IndexOutOfBoundsException("Invalid abscissa : pixel out");
			}
			if ( y1 < 0 || y1 >= hauteur || y2 < 0 || y2 >= hauteur ) {
				throw new IndexOutOfBoundsException("Invalid ordinate : pixel out");
			}
			
			try {
	 			MyColor.parseMyColor(color);
	 		}
	 		catch (ColorNotFoundException e) {
	 			System.out.println ("Invalid foreground color. Black used instead");
	 			color = "black";
	 		}

			// Bresenham algorithm. Implementation entirely poached from Kenny Hoff (95).

			int dX = x2 > x1 ? x2-x1 : x1-x2;
  			int dY = y2 > y1 ? y2-y1 : y1-y2;;
  
  			if (x1 > x2) { Xincr = -1; } else { Xincr = 1; }
  			if (y1 > y2) { Yincr = -1; } else { Yincr = 1; }
  			
  			x = x1;
  			y = y1;
  			try {
  				if (dX >= dY) {           
    				int dPr  = dY<<1;
    				int dPru = dPr - (dX<<1);
    				int P    = dPr - dX;

    				while (dX >=0 ) {
      				/* on n'utilise pas drawPoint pour ne pas repeter la definition de g 
      		 		* et la verification de la color */
      		 		synchronized(cp) {
							add(new APoint(x, y, color));
							setVisible(true);
						}
						//Thread.yield();
						attendre(DELAI);		// pour eviter une execution trop rapide...
      				if (P > 0) { 
        					x += Xincr;
							y += Yincr;
        					P += dPru;  
      				}
      				else {
        					x += Xincr;
        					P += dPr;   
      				}
      				dX--;
    				}    
  				}
  				else {
    				int dPr	= dX<<1;         
    				int dPru	= dPr - (dY<<1);
    				int P		= dPr - dY;

    				while (dY>=0) {
      		 		synchronized(cp) {
							add(new APoint(x, y, color));
							setVisible(true);
						}
						//Thread.yield();
               	attendre(DELAI);
      				if (P > 0) { 
        					x += Xincr;
        					y += Yincr;
        					P += dPru;  
      				}
      				else {
        					y += Yincr;
        					P += dPr;
      				}
   					dY--; 
   				}    
				} 
			}
			catch (InterruptedException e) {
				System.out.println("Problem :  thread interrupted");
			}
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println( e.getMessage() );
		}
	}	
	
	/**
	 * Plots a black line from point (x1, y1) to point (x2, y2)
	 */  
	private void plotLine (int x1, int y1, int x2, int y2) {
		plotLine(x1, y1, x2, y2, "black");
	}

 	/**
	 * Plots a line of color color from point pt1 to point pt2
	 */  
	 public void plotLine (Point pt1, Point pt2, String color) {
	 	plotLine(pt1.x, pt1.y, pt2.x, pt2.y, color);
	 }

 	/**
	 * Plots a black line from point pt1 to point pt2
	 */  
	 public void plotLine (Point pt1, Point pt2) {
	 	plotLine(pt1.x, pt1.y, pt2.x, pt2.y, "black");
	 }
	 
/*--------------------------  L'ATTENTE  -------------------------------------------*/
/* pour remplacer Thread.yield() si l'execution est trop rapide !!! 
   (on n'arrive pas bien a visualiser le parallelisme) */

		private static void attendre (long duree) throws InterruptedException {
      	Thread.sleep(duree);
		}

}
