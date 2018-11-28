package graphic ;

import java.awt.Color;

public class MyColor {

/** construit un objet Color à partir d'une chaine représentant un nom de couleur 
    tel que défini par la norme SVG 1.0 */
    
	public static Color parseMyColor (String colorStr) throws ColorNotFoundException {
		
		if ( colorStr.equalsIgnoreCase ("alice blue") ) 		{ return new Color (0xf0f8ff); }
		if ( colorStr.equalsIgnoreCase ("antique white") ) 	{ return new Color (0xfaebd7); }
  		if ( colorStr.equalsIgnoreCase ("aqua") ) 				{ return new Color (0x00ffff); }
  		if ( colorStr.equalsIgnoreCase ("aquamarine") ) 		{ return new Color (0x7fffd4); }
  		if ( colorStr.equalsIgnoreCase ("azure") ) 				{ return new Color (0xf0ffff); }
  		if ( colorStr.equalsIgnoreCase ("beige") ) 				{ return new Color (0xf5f5dc); }
  		if ( colorStr.equalsIgnoreCase ("bisque") ) 				{ return new Color (0xffe4c4); }
  		if ( colorStr.equalsIgnoreCase ("black") ) 				{ return new Color (0x000000); }
  		if ( colorStr.equalsIgnoreCase ("blanched almond") )	{ return new Color (0xffebcd); }
  		if ( colorStr.equalsIgnoreCase ("blue") ) 				{ return new Color (0x0000ff); }
  		if ( colorStr.equalsIgnoreCase ("blue violet") ) 		{ return new Color (0x8a2be2); }
  		if ( colorStr.equalsIgnoreCase ("brown") ) 				{ return new Color (0xa52a2a); }
  		if ( colorStr.equalsIgnoreCase ("burlywood") ) 			{ return new Color (0xdeb887); }
  		if ( colorStr.equalsIgnoreCase ("cadet blue") ) 		{ return new Color (0x5f9ea0); }
  		if ( colorStr.equalsIgnoreCase ("chartreuse") ) 		{ return new Color (0x7fff00); }
  		if ( colorStr.equalsIgnoreCase ("chocolate") ) 			{ return new Color (0xd2691e); }
  		if ( colorStr.equalsIgnoreCase ("coral") ) 				{ return new Color (0xff7f50); }
  		if ( colorStr.equalsIgnoreCase ("cornflower blue") ) 	{ return new Color (0x6495ed); }
  		if ( colorStr.equalsIgnoreCase ("cornsilk") ) 			{ return new Color (0xfff8dc); }
  		if ( colorStr.equalsIgnoreCase ("crimson") ) 			{ return new Color (0xdc143c); }
  		if ( colorStr.equalsIgnoreCase ("cyan") ) 				{ return new Color (0x00ffff); }
  		if ( colorStr.equalsIgnoreCase ("dark blue") ) 			{ return new Color (0x00008b); }
  		if ( colorStr.equalsIgnoreCase ("dark cyan") ) 			{ return new Color (0x008b8b); }
  		if ( colorStr.equalsIgnoreCase ("dark goldenrod") ) 	{ return new Color (0xb8860b); }
  		if ( colorStr.equalsIgnoreCase ("dark gray") ) 			{ return new Color (0xa9a9a9); }
  		if ( colorStr.equalsIgnoreCase ("dark green") ) 		{ return new Color (0x006400); }
  		if ( colorStr.equalsIgnoreCase ("dark khaki") ) 		{ return new Color (0xbdb76b); }
  		if ( colorStr.equalsIgnoreCase ("dark magenta") ) 		{ return new Color (0x8b008b); }
  		if ( colorStr.equalsIgnoreCase ("dark olive green") )	{ return new Color (0x556b2f); }
		if ( colorStr.equalsIgnoreCase ("dark orange") ) 		{ return new Color (0xff8c00); }
  		if ( colorStr.equalsIgnoreCase ("dark orchid") ) 		{ return new Color (0x9932cc); }
  		if ( colorStr.equalsIgnoreCase ("dark red") ) 			{ return new Color (0x8b0000); }
		if ( colorStr.equalsIgnoreCase ("dark salmon") ) 		{ return new Color (0xe9967a); }
  		if ( colorStr.equalsIgnoreCase ("dark seagreen") ) 	{ return new Color (0x8dbc8f); }
  		if ( colorStr.equalsIgnoreCase ("dark slate blue") ) 	{ return new Color (0x483d8b); }
  		if ( colorStr.equalsIgnoreCase ("dark slate gray") ) 	{ return new Color (0x2f4f4f); }
  		if ( colorStr.equalsIgnoreCase ("dark turquoise") ) 	{ return new Color (0x00ded1); }
  		if ( colorStr.equalsIgnoreCase ("dark violet") ) 		{ return new Color (0x9400d3); }
   	if ( colorStr.equalsIgnoreCase ("deep pink") ) 			{ return new Color (0xff1493); }
   	if ( colorStr.equalsIgnoreCase ("deep sky blue") ) 	{ return new Color (0x00bfff); }
  		if ( colorStr.equalsIgnoreCase ("dim gray") ) 			{ return new Color (0x696969); }
  		if ( colorStr.equalsIgnoreCase ("dodger blue") ) 		{ return new Color (0x1e90ff); }
    	if ( colorStr.equalsIgnoreCase ("firebrick") ) 			{ return new Color (0xb22222); }
    	if ( colorStr.equalsIgnoreCase ("floral white") ) 		{ return new Color (0xfffaf0); }
   	if ( colorStr.equalsIgnoreCase ("forest green") ) 		{ return new Color (0x228b22); }
    	if ( colorStr.equalsIgnoreCase ("fuchsia") ) 			{ return new Color (0xff00ff); }
    	if ( colorStr.equalsIgnoreCase ("gainsboro") ) 			{ return new Color (0xdcdcdc); }
    	if ( colorStr.equalsIgnoreCase ("ghost white") ) 		{ return new Color (0xf8f8ff); }
    	if ( colorStr.equalsIgnoreCase ("gold") ) 				{ return new Color (0xffd700); }
   	if ( colorStr.equalsIgnoreCase ("goldenrod") ) 			{ return new Color (0xdaa520); }
   	if ( colorStr.equalsIgnoreCase ("grey") ) 				{ return new Color (0x808080); }
   	if ( colorStr.equalsIgnoreCase ("gray") ) 				{ return new Color (0x808080); }
   	if ( colorStr.equalsIgnoreCase ("green") ) 				{ return new Color (0x008000); }
   	if ( colorStr.equalsIgnoreCase ("green yellow") ) 		{ return new Color (0xadff2f); }
   	if ( colorStr.equalsIgnoreCase ("honeydew") ) 			{ return new Color (0xf0fff0); }
    	if ( colorStr.equalsIgnoreCase ("hot pink") ) 			{ return new Color (0xff69b4); }
    	if ( colorStr.equalsIgnoreCase ("indian red") ) 		{ return new Color (0xcd5c5c); }
    	if ( colorStr.equalsIgnoreCase ("indigo") ) 				{ return new Color (0x4b0082); }
    	if ( colorStr.equalsIgnoreCase ("ivory") ) 				{ return new Color (0xfffff0); }
    	if ( colorStr.equalsIgnoreCase ("khaki") ) 				{ return new Color (0xf0e68c); }
    	if ( colorStr.equalsIgnoreCase ("lavender") ) 			{ return new Color (0xe6e6fa); }
    	if ( colorStr.equalsIgnoreCase ("lavender blush") ) 	{ return new Color (0xfff0f5); }
    	if ( colorStr.equalsIgnoreCase ("lawn green") ) 		{ return new Color (0x7cfc00); }
    	if ( colorStr.equalsIgnoreCase ("lemon chiffon") ) 	{ return new Color (0xfffacd); }
    	if ( colorStr.equalsIgnoreCase ("light blue") ) 		{ return new Color (0xadd8e6); }
    	if ( colorStr.equalsIgnoreCase ("light coral") ) 		{ return new Color (0xf08080); }
    	if ( colorStr.equalsIgnoreCase ("light cyan") ) 		{ return new Color (0xe0ffff); }
    	if ( colorStr.equalsIgnoreCase ("light goldenrod yellow") ){ return new Color (0xfafad2); }
    	if ( colorStr.equalsIgnoreCase ("light green") ) 			{ return new Color (0x90ee90); }
    	if ( colorStr.equalsIgnoreCase ("light grey") ) 			{ return new Color (0xd3d3d3); }
    	if ( colorStr.equalsIgnoreCase ("light pink") ) 			{ return new Color (0xffb6c1); }
    	if ( colorStr.equalsIgnoreCase ("light salmon") ) 			{ return new Color (0xffa07a); }
    	if ( colorStr.equalsIgnoreCase ("light seagreen") ) 		{ return new Color (0x20b2aa); }
    	if ( colorStr.equalsIgnoreCase ("light sky blue") ) 		{ return new Color (0x87cefa); }
    	if ( colorStr.equalsIgnoreCase ("light slate gray") )		{ return new Color (0x778899); }
    	if ( colorStr.equalsIgnoreCase ("light steel blue") )		{ return new Color (0xb0c4de); }
    	if ( colorStr.equalsIgnoreCase ("light yellow") ) 			{ return new Color (0xffffe0); }
    	if ( colorStr.equalsIgnoreCase ("lime") ) 					{ return new Color (0x00ff00); }
    	if ( colorStr.equalsIgnoreCase ("lime green") ) 			{ return new Color (0x32cd32); }
    	if ( colorStr.equalsIgnoreCase ("linen") ) 					{ return new Color (0xfaf0e6); }
    	if ( colorStr.equalsIgnoreCase ("magenta") ) 				{ return new Color (0xff00ff); }
    	if ( colorStr.equalsIgnoreCase ("maroon") ) 					{ return new Color (0x800000); }
    	if ( colorStr.equalsIgnoreCase ("medium aquamarine") )	{ return new Color (0x66cdaa); }
    	if ( colorStr.equalsIgnoreCase ("medium blue") ) 			{ return new Color (0x0000cd); }
    	if ( colorStr.equalsIgnoreCase ("medium orchid") ) 		{ return new Color (0xba55d3); }
    	if ( colorStr.equalsIgnoreCase ("medium purple") ) 		{ return new Color (0x9370db); }
    	if ( colorStr.equalsIgnoreCase ("medium sea green") )		{ return new Color (0x3cb371); }
    	if ( colorStr.equalsIgnoreCase ("medium slate blue") )	{ return new Color (0x7b68ee); }
    	if ( colorStr.equalsIgnoreCase ("medium spring green") )	{ return new Color (0x00fa9a); }
    	if ( colorStr.equalsIgnoreCase ("medium turquoise") )		{ return new Color (0x48d1cc); }
    	if ( colorStr.equalsIgnoreCase ("medium violet red") )	{ return new Color (0xc71585); }
   	if ( colorStr.equalsIgnoreCase ("midnight blue") ) 		{ return new Color (0x191970); }
    	if ( colorStr.equalsIgnoreCase ("mint cream") ) 			{ return new Color (0xf5fffa); }
    	if ( colorStr.equalsIgnoreCase ("misty rose") ) 			{ return new Color (0xffe4e1); }
    	if ( colorStr.equalsIgnoreCase ("moccasin") ) 				{ return new Color (0xffe4b5); }
    	if ( colorStr.equalsIgnoreCase ("navajo white") ) 			{ return new Color (0xffdead); }
    	if ( colorStr.equalsIgnoreCase ("navy") ) 					{ return new Color (0x000080); }
    	if ( colorStr.equalsIgnoreCase ("old lace") ) 				{ return new Color (0xfdf5e6); }
    	if ( colorStr.equalsIgnoreCase ("olive") ) 					{ return new Color (0x808000); }
    	if ( colorStr.equalsIgnoreCase ("olive drab") ) 			{ return new Color (0x6b8e23); }
    	if ( colorStr.equalsIgnoreCase ("orange") ) 					{ return new Color (0xffa500); }
    	if ( colorStr.equalsIgnoreCase ("orange red") ) 			{ return new Color (0xff4500); }
    	if ( colorStr.equalsIgnoreCase ("orchid") ) 					{ return new Color (0xda70d6); }
    	if ( colorStr.equalsIgnoreCase ("pale goldenrod") ) 		{ return new Color (0xeee8aa); }
    	if ( colorStr.equalsIgnoreCase ("pale green") ) 			{ return new Color (0x98fb98); }
    	if ( colorStr.equalsIgnoreCase ("pale turquoise") ) 		{ return new Color (0xafeeee); }
    	if ( colorStr.equalsIgnoreCase ("pale violet red") ) 		{ return new Color (0xdb7093); }
    	if ( colorStr.equalsIgnoreCase ("papaya whip") ) 			{ return new Color (0xffefd5); }
    	if ( colorStr.equalsIgnoreCase ("peach puff") ) 			{ return new Color (0xffdab9); }
    	if ( colorStr.equalsIgnoreCase ("peru") ) 					{ return new Color (0xcd853f); }
    	if ( colorStr.equalsIgnoreCase ("pink") ) 					{ return new Color (0xffc8cb); }
    	if ( colorStr.equalsIgnoreCase ("plum") ) 					{ return new Color (0xdda0dd); }
    	if ( colorStr.equalsIgnoreCase ("powder blue") ) 			{ return new Color (0xb0e0e6); }
    	if ( colorStr.equalsIgnoreCase ("purple") ) 					{ return new Color (0x800080); }
    	if ( colorStr.equalsIgnoreCase ("red") ) 						{ return new Color (0xff0000); }
    	if ( colorStr.equalsIgnoreCase ("rosy brown") ) 			{ return new Color (0xbc8f8f); }
    	if ( colorStr.equalsIgnoreCase ("royal blue") ) 			{ return new Color (0x4169e1); }
    	if ( colorStr.equalsIgnoreCase ("saddle brown") ) 			{ return new Color (0x8b4513); }
    	if ( colorStr.equalsIgnoreCase ("salmon") ) 					{ return new Color (0xfa8072); }
    	if ( colorStr.equalsIgnoreCase ("sandy brown") ) 			{ return new Color (0xf4a460); }
    	if ( colorStr.equalsIgnoreCase ("sea green") ) 				{ return new Color (0x2e8b57); }
    	if ( colorStr.equalsIgnoreCase ("sea shell") ) 				{ return new Color (0xfff5ee); }
    	if ( colorStr.equalsIgnoreCase ("sienna") ) 					{ return new Color (0xa0522d); }
    	if ( colorStr.equalsIgnoreCase ("silver") ) 					{ return new Color (0xc0c0c0); }
    	if ( colorStr.equalsIgnoreCase ("sky blue") ) 				{ return new Color (0x87ceeb); }
    	if ( colorStr.equalsIgnoreCase ("slate blue") ) 			{ return new Color (0x6a5acd); }
    	if ( colorStr.equalsIgnoreCase ("slate gray") ) 			{ return new Color (0x708090); }
    	if ( colorStr.equalsIgnoreCase ("snow") ) 					{ return new Color (0xfffafa); }
    	if ( colorStr.equalsIgnoreCase ("spring green") ) 			{ return new Color (0x00ff7f); }
    	if ( colorStr.equalsIgnoreCase ("steel blue") ) 			{ return new Color (0x4682b4); }
    	if ( colorStr.equalsIgnoreCase ("tan") ) 						{ return new Color (0xd2b48c); }
    	if ( colorStr.equalsIgnoreCase ("teal") ) 					{ return new Color (0x008080); }
    	if ( colorStr.equalsIgnoreCase ("thistle") ) 				{ return new Color (0xd8bfd8); }
    	if ( colorStr.equalsIgnoreCase ("tomato") ) 					{ return new Color (0xff6347); }
    	if ( colorStr.equalsIgnoreCase ("turquoise") ) 				{ return new Color (0x40e0d0); }
    	if ( colorStr.equalsIgnoreCase ("violet") ) 					{ return new Color (0xee82ee); }
    	if ( colorStr.equalsIgnoreCase ("wheat") ) 					{ return new Color (0xf5deb3); }
    	if ( colorStr.equalsIgnoreCase ("white") ) 					{ return new Color (0xffffff); }
    	if ( colorStr.equalsIgnoreCase ("whitesmoke") ) 			{ return new Color (0xf5f5f5); }
    	if ( colorStr.equalsIgnoreCase ("yellow") ) 					{ return new Color (0xffff00); }
    	if ( colorStr.equalsIgnoreCase ("yellow green") ) 			{ return new Color (0x9acd32); }
    	
		throw new ColorNotFoundException();
  		//return null;
	}


}