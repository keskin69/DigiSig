package yellowzebra.booking;

import java.util.ArrayList;

public class Table extends ArrayList<ArrayList<String>> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> lastRow = null;
	private ArrayList<Header> header = null;

	public Table() {
		header = new ArrayList<Header>();
	}

	public void addCol(String col) {
		lastRow.add(col);
	}

	public void addHeader(String str) {
		header.add(new Header(str, false));
	}

	public void addHiddenHeader(String str) {
		header.add(new Header(str, false));
	}

	public void addNewRow() {
		if (lastRow != null) {
			add(lastRow);
		}

		lastRow = new ArrayList<String>();
	}

	public String getHTML(String tblId) {
		String str = "<TABLE id=\"" + tblId + "\">\n";

		if (!header.isEmpty()) {
			str += "<THEAD><TR>\n";
			for (Header h : header) {
				if (h.isHidden) {
					str += "<TH style=\"display:none;\">" + h.text + "</TH>\n";
				} else {
					str += "<TH>" + h.text + "</TH>\n";
				}
			}

			str += "</TR></THEAD>\n";
		}

		for (ArrayList<String> row : this) {
			str += "<TR>\n";
			for (String col : row) {
				str += "<TD>" + col + "</TD>\n";
				// hidden col
				// <td style="display:none;">
			}

			str += "</TR>\n";
		}

		str += "</TABLE>";

		return str;
	}

	class Header {
		String text;
		boolean isHidden;

		public Header(String text, boolean isHidden) {
			this.text = text;
			this.isHidden = isHidden;
		}
	}
}
