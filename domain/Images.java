package domain;

import java.awt.image.BufferedImage;

/**
 *
 * @author Albin Hernánez Rivera | Carné B68200
 */
public class Images {

    private static Images instance = new Images();

    //Atributos de la clase
    private BufferedImage[][] subImageList; // <- Matriz en donde se guarda cada sub-imagen
    private BufferedImage[][] subImageMosaic; // <- Matriz en donde se guarda cada sub-imagenes del mosaico
    private BufferedImage image; // <- imagen que se debe manipular
    private BufferedImage subImage;// <- Imagen que sera la ultima seleccionada
    private int n; // <- Tamaño de cada bloque

    // Constructor vacio, con acceso privado para asegurar que sea instanciado 
    // solamente por la propia clase.
    private Images() {
        this.n = 0;
        this.image = null;
        subImageList = null;
        subImage = null;
        subImageMosaic = new BufferedImage[10][10];
    }

    public static Images getInstance() {
        return instance;
    }

    // Este método retorna un array bidimensional de imagenes en donde
    // "n" representa el tamano de cada cuadro (cada sub-imagen) e
    // "image" representa la imagen que se va a dividir. Divide la imagen
    // ingresada por el usuario.
    public void arrayOfImages() {
        subImageList = new BufferedImage[image.getHeight() / n][image.getWidth() / n];
        
        // for que controla las filas (eje y)
        for (int i = 0; i < subImageList.length; i++) {
            //for que controla las columnas (eje x)
            for (int j = 0; j < subImageList[0].length; j++) {
                subImageList[i][j] = image.getSubimage(j * n, i * n, n, n); //(x, y, ancho, alto)
            }//fin for j
        }//fin for i
    }//fin arrayOfImages 

    // Método que seleciona la una imagen clikeada
    public void copyImage(int mX, int mY) {
        int witdh = (subImageList.length * n);
        int height = (subImageList[0].length * n);
        //comprueba que el click se dio dentro de la imagen
        if (mY < witdh && mX < height) {
            int x1 = mX / n;
            int y1 = mY / n;
            subImage = subImageList[y1][x1];
        }//fin if
        
    }//fin copyImage
    
    
    public void listOfMosaicImages(int x, int y){
        subImageMosaic[x][y] = subImage;
    }
    
    public BufferedImage getSelectedBufered(int x, int y){
        return subImageMosaic[x][y];
    }

    // Métodos de acceso
    public BufferedImage[][] getSubImageList() {
        return subImageList;
    }

    public void setSubImageList(BufferedImage[][] subImageList) {
        this.subImageList = subImageList;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public BufferedImage getSubImage() {
        return subImage;
    }

    public void setSubImage(BufferedImage subImage) {
        this.subImage = subImage;
    }

    public BufferedImage[][] getSubImageMosaic() {
        return subImageMosaic;
    }

    public void setSubImageMosaic(BufferedImage[][] subImageMosaic) {
        this.subImageMosaic = subImageMosaic;
    }
    

}
