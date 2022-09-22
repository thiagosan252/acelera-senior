package part2;
public class Usuario {
    private String usuario = "ADMIN";
    private String senha = "ADMIN";

    public Usuario() {

    }

    public String getSenha() {
        return senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
