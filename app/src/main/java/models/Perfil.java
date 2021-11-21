package models;

import android.media.Image;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Perfil {

    private String nome;
    private String senha;
    private String usuario;
    private String email;
    private String instituicao;
    private int usuarioid;
    private String usuarioimagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getUsuarioimagem() {
        return usuarioimagem;
    }

    public void setUsuarioimagem(String usuarioimagem) {
        this.usuarioimagem = usuarioimagem;
    }

    public static String parseJson(Perfil perfil) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nome", perfil.getNome());
            jsonObject.put("usuarioid", perfil.getUsuarioid());
            jsonObject.put("senha", perfil.getSenha());
            jsonObject.put("usuario", perfil.getUsuario());
            jsonObject.put("email", perfil.getEmail());
            jsonObject.put("instituicao", perfil.getInstituicao());
            jsonObject.put("usuarioimagem", perfil.getUsuarioimagem());
            return jsonObject.toString();
        } catch (Exception ex) {
            return "";
        }
    }

    public static ArrayList<Perfil> parseObject(String json) {
        ArrayList<Perfil> perfis = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Perfil perfil = new Perfil();
                JSONObject obj = array.getJSONObject(i);
                perfil.setNome(obj.getString("nome"));
                perfil.setSenha(obj.getString("senha"));
                perfil.setUsuario(obj.getString("usuario"));
                perfil.setEmail(obj.getString("email"));
                perfil.setInstituicao(obj.getString("instituicao"));
                perfil.setUsuarioid(obj.getInt("usuarioid"));
                perfil.setUsuarioimagem(obj.getString("usuarioimagem"));
                perfis.add(perfil);
            }
            return perfis;
        } catch (Exception ex) {
            return perfis;
        }
    }

    public static Perfil parseOneObject(String json) {
        try {
            Perfil perfil = new Perfil();
            JSONObject obj = new JSONObject(json);
            perfil.setNome(obj.getString("nome"));
            perfil.setSenha(obj.getString("senha"));
            perfil.setSenha(obj.getString("usuario"));
            perfil.setSenha(obj.getString("email"));
            perfil.setSenha(obj.getString("instituicao"));
            perfil.setUsuarioid(obj.getInt("usuarioid"));
            perfil.setUsuarioimagem(obj.getString("usuarioimagem"));
            return perfil;
        } catch (Exception ex) {
            return null;
        }
    }

    public Perfil() {
    }

    public Perfil(int usuarioid, String nome, String senha, String usuario, String email, String instituicao, String usuarioimagem) {
        usuarioid = usuarioid;
        nome = nome;
        senha = senha;
        email = email;
        instituicao = instituicao;
        usuario = usuario;
        usuarioimagem = usuarioimagem;
    }
}
