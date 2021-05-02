package com.nguyenng.slicer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Slicer {
	private BufferedImage image;
	private int width, height;
	private String filepath;

	public Slicer(File file) {
		this.image = null;
		try {
			this.image = ImageIO.read(file);
			this.filepath = file.getAbsolutePath().substring(0, file.getAbsolutePath().indexOf("."));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
	}

	public void slice(int tileW, int tileH) {
		for (int y = 0; y < this.height / tileH; y++) {
			for (int x = 0; x < this.width / tileW; x++) {
				int[] p = this.image.getRGB(x * tileW, y * tileH, tileW, tileH, null, 0, tileW);
				BufferedImage tile = new BufferedImage(tileW, tileH, BufferedImage.TYPE_INT_ARGB);
				tile.setRGB(0, 0, tileW, tileH, p, 0, tileW);
				try {
					ImageIO.write(tile, "png", new File(this.filepath + "-output" + (y * tileW + x) + ".png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
