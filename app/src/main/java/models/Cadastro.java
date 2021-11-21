package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cadastro {

    private String Nome;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getInstituicao() {
        return Instituicao;
    }

    public void setInstituicao(String instituicao) {
        Instituicao = instituicao;
    }

    public String getTermosdeuso() {
        return Termosdeuso;
    }

    public void setTermosdeuso(String termosdeuso) {
        Termosdeuso = termosdeuso;
    }

    public String getTermosdeprivacidade() {
        return Termosdeprivacidade;
    }

    public void setTermosdeprivacidade(String termosdeprivacidade) {
        Termosdeprivacidade = termosdeprivacidade;
    }

    public int getUsuarioid() {
        return Usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        Usuarioid = usuarioid;
    }

    public String getUsuarioimagem() {
        return Usuarioimagem;
    }

    public void setUsuarioimagem(String usuarioimagem) {
        Usuarioimagem = usuarioimagem;
    }

    private String Senha;
    private String Usuario;
    private String Email;
    private String Instituicao;
    private String Termosdeuso;
    private String Termosdeprivacidade;
    private int Usuarioid;
    private String Usuarioimagem;


    public static String parseJson(Cadastro cadastro) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nome", cadastro.getNome());
            jsonObject.put("usuarioid", cadastro.getUsuarioid());
            jsonObject.put("senha", cadastro.getSenha());
            jsonObject.put("usuario", cadastro.getUsuario());
            jsonObject.put("email", cadastro.getEmail());
            jsonObject.put("instituicao", cadastro.getInstituicao());
            jsonObject.put("termosdeuso", cadastro.getTermosdeuso());
            jsonObject.put("termosdeprivacidade", cadastro.getTermosdeprivacidade());
            jsonObject.put("usuarioimagem", cadastro.getUsuarioimagem());
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
                cadastro.setUsuarioimagem(obj.getString("usuarioimagem"));
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
            cadastro.setUsuario(obj.getString("usuario"));
            cadastro.setEmail(obj.getString("email"));
            cadastro.setInstituicao(obj.getString("instituicao"));
            cadastro.setTermosdeuso(obj.getString("termosdeuso"));
            cadastro.setTermosdeprivacidade(obj.getString("termosdeprivacidade"));
            cadastro.setUsuarioid(obj.getInt("usuarioid"));
            cadastro.setUsuarioimagem(obj.getString("usuarioimagem"));
            return cadastro;
        } catch (Exception ex) {
            return null;
        }
    }

    public Cadastro() {
    }

    public Cadastro(int usuarioid, String nome, String senha, String usuario, String email, String instituicao, String termosdeuso, String termosdeprivacidade, String usuarioimagem) {
        Usuarioid = usuarioid;
        Nome = nome;
        Senha = senha;
        Email = email;
        Instituicao = instituicao;
        Usuario = usuario;
        Termosdeuso = termosdeuso;
        Termosdeprivacidade = termosdeprivacidade;
        Usuarioimagem = usuarioimagem;
    }
}
