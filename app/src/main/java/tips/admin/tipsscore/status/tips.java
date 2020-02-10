package tips.admin.tipsscore.status;

public class tips {
    String time;
    String league ;
    String match ;
    String tip ;
    String odd ;
    String results ;
    String status;



    public tips(String status, String time , String league , String match , String tip , String odd , String results) {
        this.time=time;

        this.league=league;
        this.match=match;
        this.tip=tip;
        this.odd=odd;
        this.results=results;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status=status;
    }

    public String getLeague() {
        return league;
    }

    public String getTime() {
        return time;
    }

    public String getMatch() {
        return match;
    }

    public String getTip() {
        return tip;
    }

    public String getOdd() {
        return odd;
    }

    public String getResults() {
        return results;
    }
}


