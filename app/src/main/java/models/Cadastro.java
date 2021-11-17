package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cadastro {

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

    public String getTermosdeuso() {
        return termosdeuso;
    }

    public void setTermosdeuso(String termosdeuso) {
        this.termosdeuso = termosdeuso;
    }

    public String getTermosdeprivacidade() {
        return termosdeprivacidade;
    }

    public void setTermosdeprivacidade(String termosdeprivacidade) {
        this.termosdeprivacidade = termosdeprivacidade;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    private String nome;
    private String senha;
    private String usuario;
    private String email;
    private String instituicao;
    private String termosdeuso;
    private String termosdeprivacidade;
    private int usuarioid;

    public static String parseJson(Cadastro cadastro) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nome", cadastro.getNome());
            jsonObject.put("senha", cadastro.getSenha());
            jsonObject.put("usuario", cadastro.getUsuario());
            jsonObject.put("email", cadastro.getEmail());
            jsonObject.put("instituicao", cadastro.getInstituicao());
            jsonObject.put("termosdeuso", cadastro.getTermosdeuso());
            jsonObject.put("termosdeprivacidade", cadastro.getTermosdeprivacidade());
            return jsonObject.toString();
        } catch (Exception ex) {
            return "";
        }
    }

    public static ArrayList<Cadastro> parseObject(String json) {
        ArrayList<Cadastro> cadastros = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Cadastro cadastro = new Cadastro();
                JSONObject obj = array.getJSONObject(i);
                cadastro.setNome(obj.getString("nome"));
                cadastro.setSenha(obj.getString("senha"));
                cadastro.setUsuario(obj.getString("usuario"));
                cadastro.setEmail(obj.getString("email"));
                cadastro.setInstituicao(obj.getString("instituicao"));
                cadastro.setTermosdeuso(obj.getString("termosdeuso"));
                cadastro.setTermosdeprivacidade(obj.getString("termosdeprivacidade"));
                cadastro.setUsuarioid(obj.getInt("usuarioid"));
                cadastros.add(cadastro);
            }
            return cadastros;
        } catch (Exception ex) {
            return cadastros;
        }
    }

    public static Cadastro parseOneObject(String json) {
        try {
            Cadastro cadastro = new Cadastro();
            JSONObject obj = new JSONObject(json);
            cadastro.setNome(obj.getString("nome"));
            cadastro.setSenha(obj.getString("senha"));
            cadastro.setSenha(obj.getString("usuario"));
            cadastro.setSenha(obj.getString("email"));
            cadastro.setSenha(obj.getString("instituicao"));
            cadastro.setSenha(obj.getString("termosdeuso"));
            cadastro.setSenha(obj.getString("termosdeprivacidade"));
            cadastro.setUsuarioid(obj.getInt("usuarioid"));
            return cadastro;
        } catch (Exception ex) {
            return null;
        }
    }

    public Cadastro() {
    }

    public Cadastro(int usuarioid, String nome, String senha,String usuario,String email, String instituicao, String termosdeuso,String termosdeprivacidade) {
        usuarioid = usuarioid;
        nome = nome;
        senha = senha;
        email = email;
        instituicao = instituicao;
        usuario = usuario;
        termosdeuso = termosdeuso;
        termosdeprivacidade = termosdeprivacidade;
    }
}
