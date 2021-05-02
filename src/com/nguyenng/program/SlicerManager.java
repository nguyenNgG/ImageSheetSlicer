package com.nguyenng.program;

import com.nguyenng.slicer.Printer;
import com.nguyenng.slicer.Slicer;

public class SlicerManager {
	
	private Slicer imageSlicer;
	private Printer slicePrinter;
	
	public SlicerManager(String path) {
		this.imageSlicer = new Slicer(path);
		this.slicePrinter = new Printer();
	}
	
	public Slicer getImageSlicer() {
		return imageSlicer;
	}

	public void setImageSlicer(Slicer imageSlicer) {
		this.imageSlicer = imageSlicer;
	}
	
	public Printer getSlicePrinter() {
		return slicePrinter;
	}

	public void setSlicePrinter(Printer slicePrinter) {
		this.slicePrinter = slicePrinter;
	}
	
	public static void main(String[] args) {
		SlicerManager smgt = new SlicerManager("/input.png");
		smgt.getImageSlicer().slice(4, 4);
		smgt.getSlicePrinter().setSlices(smgt.getImageSlicer().getSlices());
		smgt.getSlicePrinter().printToFile();
//		SlicerManager smgt = new SlicerManager(args[0]);
//		smgt.getImageSlicer().slice(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
	}

}
