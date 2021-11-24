package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cadastro {

    private String Senha;
    private String Usuario;
    private String Email;
    private String Instituicao;
    private boolean TermosdeUso;
    private boolean TermosdePrivacidade;
    private int Usuarioid;
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

    public int getUsuarioid() {
        return Usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        Usuarioid = usuarioid;
    }


    public boolean getTermosdeUso() {
        return TermosdeUso;
    }

    public void setTermosdeUso(boolean termosdeUso) {
        TermosdeUso = termosdeUso;
    }

    public boolean getTermosdePrivacidade() {
        return TermosdePrivacidade;
    }

    public void setTermosdePrivacidade(boolean termosdePrivacidade) {
        TermosdePrivacidade = termosdePrivacidade;
    }


    public static String parseJson(Cadastro cadastro) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nome", cadastro.getNome());
            jsonObject.put("usuarioid", cadastro.getUsuarioid());
            jsonObject.put("senha", cadastro.getSenha());
            jsonObject.put("usuario", cadastro.getUsuario());
            jsonObject.put("email", cadastro.getEmail());
            jsonObject.put("instituicao", cadastro.getInstituicao());
            jsonObject.put("termosdeuso", cadastro.getTermosdeUso());
            jsonObject.put("termosdeprivacidade", cadastro.getTermosdePrivacidade());
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
                cadastro.setTermosdeUso(obj.getBoolean("termosdeuso"));
                cadastro.setTermosdePrivacidade(obj.getBoolean("termosdeprivacidade"));
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
            cadastro.setUsuario(obj.getString("usuario"));
            cadastro.setEmail(obj.getString("email"));
            cadastro.setInstituicao(obj.getString("instituicao"));
            cadastro.setTermosdeUso(obj.getBoolean("termosdeuso"));
            cadastro.setTermosdePrivacidade(obj.getBoolean("termosdeprivacidade"));
            cadastro.setUsuarioid(obj.getInt("usuarioid"));
            return cadastro;
        } catch (Exception ex) {
            return null;
        }
    }

    public Cadastro() {
    }

    public Cadastro(int usuarioid, String nome, String senha, String usuario, String email, String instituicao,boolean termosdeuso,boolean termosdeprivacidade) {
        Usuarioid = usuarioid;
        Nome = nome;
        Senha = senha;
        Email = email;
        Instituicao = instituicao;
        TermosdeUso = termosdeuso;
        TermosdePrivacidade = termosdeprivacidade;
        Usuario = usuario;
    }
}
