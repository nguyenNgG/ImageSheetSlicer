package com.nguyenng.program;

import java.io.File;

import com.nguyenng.slicer.Slicer;

public class SlicerManager {
	
	private Slicer imageSlicer;
	
	public SlicerManager(String path) {
		File file = new File(path);
		this.imageSlicer = new Slicer(file);
	}
	
	public Slicer getImageSlicer() {
		return imageSlicer;
	}

	public void setImageSlicer(Slicer imageSlicer) {
		this.imageSlicer = imageSlicer;
	}
	
	public static void main(String[] args) {
		SlicerManager smgt = new SlicerManager(args[0]);
		smgt.getImageSlicer().slice(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
	}

}
