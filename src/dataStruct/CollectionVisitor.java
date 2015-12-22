package dataStruct;

public class CollectionVisitor {
	private int vcount;
	private int fcount;
	private Comparable fdata;

	public int getVcount() {
		return vcount;
	}

	public int getFcount() {
		return fcount;
	}

	public CollectionVisitor() {
		super();
		vcount = 0;
		fcount = 0;
		fdata = null;
	}

	public CollectionVisitor(Comparable fdata) {
		super();
		vcount = 0;
		fcount = 0;
		this.fdata = fdata;
	}

	public void visit(Comparable data) {
		if (data == null) {
			if (fdata == null)
				fcount++;
		} else {
			if (fdata != null && data.compareTo(fdata) == 0)
				fcount++;
		}
		vcount++;
		System.out.printf(
				"visit count %d finding %s found count %d element data %s\n",
				vcount, (fdata == null) ? "null" : fdata.toString(), fcount,
				(data == null) ? "null" : data.toString());
	}

}
