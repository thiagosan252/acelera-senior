package part1;

public class Login {

    private String usuario;
    private String senha;

    public Boolean executaLogin(String usuario, String senha) {
        Usuario usuarioDB = new Usuario();

        if (usuarioDB.getUsuario().equals(usuario) &&
                usuarioDB.getSenha().equals(senha))
            return true;
        else
            return false;
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
