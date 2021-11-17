package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cadastro {

    private String Nome;
    private String Senha;
    private String Usuario;
    private String Email;
    private String Instituicao;
    private String TermoDeUso;
    private String TermoDePrivacidade;
    private int Id;

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

    public String getTermoDeUso() {
        return TermoDeUso;
    }

    public void setTermoDeUso(String termoDeUso) {
        TermoDeUso = termoDeUso;
    }

    public String getTermoDePrivacidade() {
        return TermoDePrivacidade;
    }

    public void setTermoDePrivacidade(String termoDePrivacidade) {
        TermoDePrivacidade = termoDePrivacidade;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

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

    public static String parseJson(Cadastro cadastro) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Nome", cadastro.getNome());
            jsonObject.put("Senha", cadastro.getSenha());
            jsonObject.put("Usuario", cadastro.getUsuario());
            jsonObject.put("Email", cadastro.getEmail());
            jsonObject.put("Instituicao", cadastro.getInstituicao());
            jsonObject.put("TermoDeUso", cadastro.getTermoDeUso());
            jsonObject.put("TermoDePrivacidade", cadastro.getTermoDePrivacidade());
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
                cadastro.setNome(obj.getString("Nome"));
                cadastro.setSenha(obj.getString("Senha"));
                cadastro.setUsuario(obj.getString("Usuario"));
                cadastro.setEmail(obj.getString("Email"));
                cadastro.setInstituicao(obj.getString("Instituicao"));
                cadastro.setTermoDeUso(obj.getString("TermoDeUso"));
                cadastro.setTermoDePrivacidade(obj.getString("TermoDePrivacidade"));
                cadastro.setId(obj.getInt("id"));
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
            cadastro.setNome(obj.getString("Nome"));
            cadastro.setSenha(obj.getString("Senha"));
            cadastro.setSenha(obj.getString("Email"));
            cadastro.setSenha(obj.getString("Instituicao"));
            cadastro.setSenha(obj.getString("Usuario"));
            cadastro.setSenha(obj.getString("TermoDeUso"));
            cadastro.setSenha(obj.getString("TermoDePrivacidade"));
            cadastro.setId(obj.getInt("id"));
            return cadastro;
        } catch (Exception ex) {
            return null;
        }
    }

    public Cadastro() {
    }

    public Cadastro(int id, String nome, String senha,String usuario,String email, String instituicao, String termodeuso,String termodeprivacidade) {
        Id = id;
        Nome = nome;
        Senha = senha;
        Email = email;
        Instituicao = instituicao;
        Usuario = usuario;
        TermoDeUso = termodeuso;
        TermoDePrivacidade = termodeprivacidade;
    }
}
