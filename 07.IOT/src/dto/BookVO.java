package dto;

public class BookVO {
private String TITLE       ;
private String NAME        ;
private String ISBN        ;
private String COMPANY     ;
private int COST           ;
private int QTY            ;
private int PRICE          ;
public String getTITLE() {
	return TITLE;
}
public void setTITLE(String tITLE) {
	TITLE = tITLE;
}
public String getNAME() {
	return NAME;
}
public void setNAME(String nAME) {
	NAME = nAME;
}
public String getISBN() {
	return ISBN;
}
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
public String getCOMPANY() {
	return COMPANY;
}
public void setCOMPANY(String cOMPANY) {
	COMPANY = cOMPANY;
}
public int getCOST() {
	return COST;
}
public void setCOST(int cOST) {
	COST = cOST;
}
public int getQTY() {
	return QTY;
}
public void setQTY(int qTY) {
	QTY = qTY;
}
public int getPRICE() {
	return PRICE;
}
public void setPRICE(int pRICE) {
	PRICE = pRICE;
}


}
