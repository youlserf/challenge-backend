package primalcode.challenge.model;

public class TipoDocumentoContribuyenteDTO {
    private Long idTipoDocumento;
    private String codigoTipoDocumento;
    private String nombreTipoDocumento;
    private String descripcionTipoDocumento;
    private Integer idTipoContribuyente;
    private String nombreTipoContribuyente;

    // Add constructor
    public TipoDocumentoContribuyenteDTO(Long idTipoDocumento, String codigoTipoDocumento, String nombreTipoDocumento, String descripcionTipoDocumento, Integer idTipoContribuyente, String nombreTipoContribuyente) {
        this.idTipoDocumento = idTipoDocumento;
        this.codigoTipoDocumento = codigoTipoDocumento;
        this.nombreTipoDocumento = nombreTipoDocumento;
        this.descripcionTipoDocumento = descripcionTipoDocumento;
        this.idTipoContribuyente = idTipoContribuyente;
        this.nombreTipoContribuyente = nombreTipoContribuyente;
    }
    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getCodigoTipoDocumento() {
        return codigoTipoDocumento;
    }

    public void setCodigoTipoDocumento(String codigoTipoDocumento) {
        this.codigoTipoDocumento = codigoTipoDocumento;
    }

    public String getNombreTipoDocumento() {
        return nombreTipoDocumento;
    }

    public void setNombreTipoDocumento(String nombreTipoDocumento) {
        this.nombreTipoDocumento = nombreTipoDocumento;
    }

    public String getDescripcionTipoDocumento() {
        return descripcionTipoDocumento;
    }

    public void setDescripcionTipoDocumento(String descripcionTipoDocumento) {
        this.descripcionTipoDocumento = descripcionTipoDocumento;
    }

    public Integer getIdTipoContribuyente() {
        return idTipoContribuyente;
    }

    public void setIdTipoContribuyente(Integer idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }

    public String getNombreTipoContribuyente() {
        return nombreTipoContribuyente;
    }

    public void setNombreTipoContribuyente(String nombreTipoContribuyente) {
        this.nombreTipoContribuyente = nombreTipoContribuyente;
    }
}
