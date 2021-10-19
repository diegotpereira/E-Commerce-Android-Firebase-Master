package br.java.e_commerce_android_firebase_master.items;

public class SliderItem {

    private String descricao;
    private String imagemUrl;

    public SliderItem() {
    }

    public SliderItem(String descricao, String imagemUrl) {
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
