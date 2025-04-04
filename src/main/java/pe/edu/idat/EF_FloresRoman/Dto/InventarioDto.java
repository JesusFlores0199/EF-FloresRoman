package pe.edu.idat.EF_FloresRoman.Dto;
public class InventarioDto {
    private Integer idProduct;
    private Integer cantidadReal;
    // Getters and setters
    public Integer getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }
    public Integer getCantidadReal() {
        return cantidadReal;
    }
    public void setCantidadReal(Integer cantidadReal) {
        this.cantidadReal = cantidadReal;
    }
}