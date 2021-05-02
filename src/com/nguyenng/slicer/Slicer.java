package com.nguyenng.slicer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.nguyenng.slicer.slice.Slice;

public class Slicer {
	private List<Slice> slices;
	private BufferedImage image;
	private int width, height;

	public Slicer(String path) {
		image = null;
		try {
			image = ImageIO.read(Slicer.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.width = image.getWidth();
		this.height = image.getHeight();
	}

	public void slice(int tileW, int tileH) {
		this.slices = new ArrayList<>();

		for (int y = 0; y < this.height / tileH; y++) {
			for (int x = 0; x < this.width / tileW; x++) {
				int newX = (x == 0) ? 0 : x * tileW;
				int newY = (y == 0) ? 0 : y * tileH;
				int[] p = image.getRGB(newX, newY, tileW, tileH, null, 0, tileW);

				Slice newSlice = new Slice(p, tileW, tileH);
				slices.add(newSlice);
			}
		}
	}

	public List<Slice> getSlices() {
		return slices;
	}

	public void setSlices(List<Slice> slices) {
		this.slices = slices;
	}
}
