package com.nguyenng.slicer.slice;

public class Slice {
	private int[] p;
	private int tileW, tileH;
	
	public Slice(int[] pSlice, int tileW, int tileH) {
		this.p = pSlice;
		this.tileW = tileW;
		this.tileH = tileH;
	}

	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}

	public int getTileW() {
		return tileW;
	}

	public int getTileH() {
		return tileH;
	}
	
}
