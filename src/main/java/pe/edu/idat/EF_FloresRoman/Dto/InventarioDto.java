package pe.edu.idat.EF_FloresRoman.Dto;
public class InventarioDto {
    private Long idProduct;
    private Integer cantidadReal;
    // Getters and setters
    public Long getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(Long idProduct) {this.idProduct = idProduct;}
    public Integer getCantidadReal() {return cantidadReal;}
    public void setCantidadReal(Integer cantidadReal) {this.cantidadReal = cantidadReal;}
}