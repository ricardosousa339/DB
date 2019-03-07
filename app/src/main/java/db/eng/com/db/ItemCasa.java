package db.eng.com.db;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class ItemCasa {

    final public static String QUARTO = "QUARTO";
    final public static String COZINHA = "COZINHA";
    final public static String SALA = "SALA";
    final public static String AREA_DE_SERVICO = "AREA_DE_SERVICO";
    final public static String BANHEIRO = "BANHEIRO";
    final public static String AREA = "AREA";

    private String nome;
    private Integer quantidadeTotal;
    private Integer quantidadeConcluida;
    private String icone;
    private String detalhes1;
    private String detalhes2;
    private String detalhes3;

    public ItemCasa() {

    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public ItemCasa(String nome, Integer quantidadeTotal, Integer quantidadeConcluida) {
        this.nome = nome;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeConcluida = quantidadeConcluida;
    }

    public String getDetalhes1() {
        return detalhes1;
    }

    public void setDetalhes1(String detalhes1) {
        this.detalhes1 = detalhes1;
    }

    public String getDetalhes2() {
        return detalhes2;
    }

    public void setDetalhes2(String detalhes2) {
        this.detalhes2 = detalhes2;
    }

    public String getDetalhes3() {
        return detalhes3;
    }

    public void setDetalhes3(String detalhes3) {
        this.detalhes3 = detalhes3;
    }

    public ItemCasa(String nome, Integer quantidadeTotal, Integer quantidadeConcluida, String icone, String detalhes1, String detalhes2, String detalhes3) {
        this.nome = nome;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeConcluida = quantidadeConcluida;
        this.icone = icone;
        this.detalhes1 = detalhes1;
        this.detalhes2 = detalhes2;
        this.detalhes3 = detalhes3;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public Integer getQuantidadeConcluida() {
        return quantidadeConcluida;
    }

    public void setQuantidadeConcluida(Integer quantidadeConcluida) {
        this.quantidadeConcluida = quantidadeConcluida;
    }

}
