package cn.lym77.data;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 棋子大小：41*41 棋盘大小：377*417 377=41*9+1*8
 * 
 * @author LYM
 * 
 */
public class MyImg {
	// b:黑色，r：红色
	// a：士；b：象；c：炮；k：将；n：马；p：卒；r：车
	// s：选择
	// oo：空
	// oos：选择
	public static BufferedImage ba, bas, bb, bbs, bc, bcs, bk, bks, bn, bns,
			bp, bps, br, brs;
	public static BufferedImage ra, ras, rb, rbs, rc, rcs, rk, rks, rn, rns,
			rp, rps, rr, rrs;
	public static BufferedImage oo, oos, wood;

	public static void initImg() throws IOException {
		ba= ImageIO.read(MyImg.class.getResource("image/wood/ba.gif"));
		bas = ImageIO.read(MyImg.class.getResource("image/wood/bas.gif"));
		bb = ImageIO.read(MyImg.class.getResource("image/wood/bb.gif"));
		bbs = ImageIO.read(MyImg.class.getResource("image/wood/bbs.gif"));
		bc = ImageIO.read(MyImg.class.getResource("image/wood/bc.gif"));
		bcs = ImageIO.read(MyImg.class.getResource("image/wood/bcs.gif"));
		bk = ImageIO.read(MyImg.class.getResource("image/wood/bk.gif"));
		bks = ImageIO.read(MyImg.class.getResource("image/wood/bks.gif"));
		bn = ImageIO.read(MyImg.class.getResource("image/wood/bn.gif"));
		bns = ImageIO.read(MyImg.class.getResource("image/wood/bns.gif"));
		bp = ImageIO.read(MyImg.class.getResource("image/wood/bp.gif"));
		bps = ImageIO.read(MyImg.class.getResource("image/wood/bps.gif"));
		br = ImageIO.read(MyImg.class.getResource("image/wood/br.gif"));
		brs = ImageIO.read(MyImg.class.getResource("image/wood/brs.gif"));

		ra = ImageIO.read(MyImg.class.getResource("image/wood/ra.gif"));
		ras = ImageIO.read(MyImg.class.getResource("image/wood/ras.gif"));
		rb = ImageIO.read(MyImg.class.getResource("image/wood/rb.gif"));
		rbs = ImageIO.read(MyImg.class.getResource("image/wood/rbs.gif"));
		rc = ImageIO.read(MyImg.class.getResource("image/wood/rc.gif"));
		rcs = ImageIO.read(MyImg.class.getResource("image/wood/rcs.gif"));
		rk = ImageIO.read(MyImg.class.getResource("image/wood/rk.gif"));
		rks = ImageIO.read(MyImg.class.getResource("image/wood/rks.gif"));
		rn = ImageIO.read(MyImg.class.getResource("image/wood/rn.gif"));
		rns = ImageIO.read(MyImg.class.getResource("image/wood/rns.gif"));
		rp = ImageIO.read(MyImg.class.getResource("image/wood/rp.gif"));
		rps = ImageIO.read(MyImg.class.getResource("image/wood/rps.gif"));
		rr = ImageIO.read(MyImg.class.getResource("image/wood/rr.gif"));
		rrs = ImageIO.read(MyImg.class.getResource("image/wood/rrs.gif"));
		oo = ImageIO.read(MyImg.class.getResource("image/wood/oo.gif"));
		oos = ImageIO.read(MyImg.class.getResource("image/wood/oos.gif"));
		wood = ImageIO.read(MyImg.class.getResource("image/wood.gif"));
	}
}
