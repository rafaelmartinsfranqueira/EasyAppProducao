package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Dashboard {

    private String dashboardmateria1;
    private String dashboardmateria2;
    private String dashboardmateria3;
    private String dashboardmateria4;
    private String dashboardmedia1;
    private String dashboardmedia2;
    private String dashboardmedia3;
    private String dashboardmedia4;
    private String dashboardmeta1;
    private String dashboardmeta2;
    private String dashboardmeta3;
    private String dashboardmeta4;

    public String getDashboardmateria1() {
        return dashboardmateria1;
    }

    public void setDashboardmateria1(String dashboardmateria1) {
        this.dashboardmateria1 = dashboardmateria1;
    }

    public String getDashboardmateria2() {
        return dashboardmateria2;
    }

    public void setDashboardmateria2(String dashboardmateria2) {
        this.dashboardmateria2 = dashboardmateria2;
    }

    public String getDashboardmateria3() {
        return dashboardmateria3;
    }

    public void setDashboardmateria3(String dashboardmateria3) {
        this.dashboardmateria3 = dashboardmateria3;
    }

    public String getDashboardmateria4() {
        return dashboardmateria4;
    }

    public void setDashboardmateria4(String dashboardmateria4) {
        this.dashboardmateria4 = dashboardmateria4;
    }

    public String getDashboardmedia1() {
        return dashboardmedia1;
    }

    public void setDashboardmedia1(String dashboardmedia1) {
        this.dashboardmedia1 = dashboardmedia1;
    }

    public String getDashboardmedia2() {
        return dashboardmedia2;
    }

    public void setDashboardmedia2(String dashboardmedia2) {
        this.dashboardmedia2 = dashboardmedia2;
    }

    public String getDashboardmedia3() {
        return dashboardmedia3;
    }

    public void setDashboardmedia3(String dashboardmedia3) {
        this.dashboardmedia3 = dashboardmedia3;
    }

    public String getDashboardmedia4() {
        return dashboardmedia4;
    }

    public void setDashboardmedia4(String dashboardmedia4) {
        this.dashboardmedia4 = dashboardmedia4;
    }

    public String getDashboardmeta1() {
        return dashboardmeta1;
    }

    public void setDashboardmeta1(String dashboardmeta1) {
        this.dashboardmeta1 = dashboardmeta1;
    }

    public String getDashboardmeta2() {
        return dashboardmeta2;
    }

    public void setDashboardmeta2(String dashboardmeta2) {
        this.dashboardmeta2 = dashboardmeta2;
    }

    public String getDashboardmeta3() {
        return dashboardmeta3;
    }

    public void setDashboardmeta3(String dashboardmeta3) {
        this.dashboardmeta3 = dashboardmeta3;
    }

    public String getDashboardmeta4() {
        return dashboardmeta4;
    }

    public void setDashboardmeta4(String dashboardmeta4) {
        this.dashboardmeta4 = dashboardmeta4;
    }

    public static String parseJson(Dashboard dashboard) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("dashboardmateria1", dashboard.getDashboardmateria1());
            jsonObject.put("dashboardmateria2", dashboard.getDashboardmateria2());
            jsonObject.put("dashboardmateria3", dashboard.getDashboardmateria3());
            jsonObject.put("dashboardmateria4", dashboard.getDashboardmateria4());
            jsonObject.put("dashboardmedia1", dashboard.getDashboardmedia1());
            jsonObject.put("dashboardmedia2", dashboard.getDashboardmedia2());
            jsonObject.put("dashboardmedia3", dashboard.getDashboardmedia3());
            jsonObject.put("dashboardmedia4", dashboard.getDashboardmedia4());
            jsonObject.put("dashboardmeta1", dashboard.getDashboardmeta1());
            jsonObject.put("dashboardmeta2", dashboard.getDashboardmeta2());
            jsonObject.put("dashboardmeta3", dashboard.getDashboardmeta3());
            jsonObject.put("dashboardmeta4", dashboard.getDashboardmeta4());
            return jsonObject.toString();
        } catch (Exception ex) {
            return "";
        }
    }

    public static ArrayList<Dashboard> parseObject(String json) {
        ArrayList<Dashboard> dashboards = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Dashboard dashboard = new Dashboard();
                JSONObject obj = array.getJSONObject(i);
                dashboard.setDashboardmateria1(obj.getString("dashboardmateria1"));
                dashboard.setDashboardmateria2(obj.getString("dashboardmateria2"));
                dashboard.setDashboardmateria3(obj.getString("dashboardmateria3"));
                dashboard.setDashboardmateria4(obj.getString("dashboardmateria4"));
                dashboard.setDashboardmedia1(obj.getString("dashboardmedia1"));
                dashboard.setDashboardmedia2(obj.getString("dashboardmedia2"));
                dashboard.setDashboardmedia3(obj.getString("dashboardmedia3"));
                dashboard.setDashboardmedia4(obj.getString("dashboardmedia4"));
                dashboard.setDashboardmeta1(obj.getString("dashboardmeta1"));
                dashboard.setDashboardmeta2(obj.getString("dashboardmeta2"));
                dashboard.setDashboardmeta3(obj.getString("dashboardmeta3"));
                dashboard.setDashboardmeta4(obj.getString("dashboardmeta4"));
                dashboards.add(dashboard);
            }
            return dashboards;
        } catch (Exception ex) {
            return dashboards;
        }
    }

    public static Dashboard parseOneObject(String json) {
        try {
            Dashboard dashboard = new Dashboard();
            JSONObject obj = new JSONObject(json);
            dashboard.setDashboardmateria1(obj.getString("dashboardmateria1"));
            dashboard.setDashboardmateria2(obj.getString("dashboardmateria2"));
            dashboard.setDashboardmateria3(obj.getString("dashboardmateria3"));
            dashboard.setDashboardmateria4(obj.getString("dashboardmateria4"));
            dashboard.setDashboardmedia1(obj.getString("dashboardmedia1"));
            dashboard.setDashboardmedia2(obj.getString("dashboardmedia2"));
            dashboard.setDashboardmedia3(obj.getString("dashboardmedia3"));
            dashboard.setDashboardmedia4(obj.getString("dashboardmedia4"));
            dashboard.setDashboardmeta1(obj.getString("dashboardmeta1"));
            dashboard.setDashboardmeta2(obj.getString("dashboardmeta2"));
            dashboard.setDashboardmeta3(obj.getString("dashboardmeta3"));
            dashboard.setDashboardmeta4(obj.getString("dashboardmeta4"));
            return dashboard;
        } catch (Exception ex) {
            return null;
        }
    }

    public Dashboard() {
    }

    public Dashboard(String dashboardmateria1, String dashboardmateria2, String dashboardmateria3, String dashboardmateria4, String dashboardmedia1, String dashboardmedia2, String dashboardmedia3, String dashboardmedia4, String dashboardmeta1, String dashboardmeta2, String dashboardmeta3, String dashboardmeta4) {
        dashboardmateria1 = dashboardmateria1;
        dashboardmateria2 = dashboardmateria2;
        dashboardmateria3 = dashboardmateria3;
        dashboardmateria4 = dashboardmateria4;
        dashboardmedia1 = dashboardmedia1;
        dashboardmedia2 = dashboardmedia2;
        dashboardmedia3 = dashboardmedia3;
        dashboardmedia4 = dashboardmedia4;
        dashboardmeta1 = dashboardmeta1;
        dashboardmeta2 = dashboardmeta2;
        dashboardmeta3 = dashboardmeta3;
        dashboardmeta4 = dashboardmeta4;

    }
}
