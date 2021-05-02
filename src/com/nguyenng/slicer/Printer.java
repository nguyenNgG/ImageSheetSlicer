package com.nguyenng.slicer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import com.nguyenng.slicer.slice.Slice;

public class Printer {
	
	private List<Slice> slices;
	
	public Printer() {
		
	}

	public List<Slice> getSlices() {
		return slices;
	}

	public void setSlices(List<Slice> slices) {
		this.slices = slices;
	}
	
	public void printToFile() {
		for(int i = 0; i < slices.size(); i++) {
			
			Slice slice = slices.get(i);
			int sliceWidth = slice.getTileW();
			int sliceHeight = slice.getTileH();
			
			BufferedImage image = new BufferedImage(sliceWidth, sliceHeight, BufferedImage.TYPE_INT_ARGB);
			
			image.setRGB(0, 0, sliceWidth, sliceHeight, slice.getP(), 0, sliceWidth);
			
			try {
				ImageIO.write(image, "png", new File("test" + i + ".png"));
				System.out.println("Written");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
