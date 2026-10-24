package uk.ac.westminster.products_api;

public class DigitalProduct {

    private String downloadUrl;
    private double filesizeMB;

    public DigitalProduct(){
            }

    public DigitalProduct(long id ,String name, double price,String downloadURl,double filesizeMB ){

        super();
        this.downloadUrl=downloadURl;
    }
    public double getFilesizeMB() {
        return filesizeMB;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }
}


