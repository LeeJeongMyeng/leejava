package book_project;

public class LibraryVo {
private String local;
private String libraryname;
public LibraryVo() {
}
public LibraryVo(String local, String libraryname) {
	this.local = local;
	this.libraryname = libraryname;
}


public LibraryVo(String local) {
	this.local = local;
}
public String getLocal() {
	return local;
}
public void setLocal(String local) {
	this.local = local;
}
public String getLibraryname() {
	return libraryname;
}
public void setLibraryname(String libraryname) {
	this.libraryname = libraryname;
}

}
