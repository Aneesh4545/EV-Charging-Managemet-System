package application;


public class DisplayAnimalData {

 

private int DisplayAnimalDataId;

private String name;

private String slides;

private String vehi_name;



public DisplayAnimalData( int DisplayAnimalDataId, String name, String slides, String vehi_name) {

this.DisplayAnimalDataId = DisplayAnimalDataId;
	
this.name = name;

this.slides = slides;

this.vehi_name = vehi_name;



}

public String getName() {

return name;

}

public void setName(String name) {

this.name = name;

}

public int getDisplayAnimalDataId() {

return DisplayAnimalDataId;

}

public void setDisplayAnimalDataId(int DisplayAnimalDataId) {

this.DisplayAnimalDataId = DisplayAnimalDataId;

}

public String getSlides() {

return slides;

}

public void setSlides(String slides) {

this.slides = slides;

}


public String getVehi_name() {

return vehi_name;

}

public void setVehi_name(String vehi_name) {

this.vehi_name = vehi_name;

}


}