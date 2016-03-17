package bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gary on 1/26/16.
 */
public class Altimeter
{
    private Integer id;
    private String flightsAscended;
    private String flightsDescended;
    private String rate;
    private String steppingGain;
    private String steppingLoss;
    private String stepsAscended;
    private String stepsDescended;
    private String totalGain;
    private String totalLoss;
    private String userId;
    private Long timestamp;

    public Integer getId()
    {
        return this.id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getFlightsAscended()
    {
        return this.flightsAscended;
    }

    public void setFlightsAscended( String flightsAscended )
    {
        this.flightsAscended = flightsAscended;
    }

    public String getFlightsDescended()
    {
        return this.flightsDescended;
    }

    public void setFlightsDescended( String flightsDescended )
    {
        this.flightsDescended = flightsDescended;
    }

    public String getRate()
    {
        return this.rate;
    }

    public void setRate( String rate )
    {
        this.rate = rate;
    }

    public String getSteppingGain()
    {
        return this.steppingGain;
    }

    public void setSteppingGain( String steppingGain )
    {
        this.steppingGain = steppingGain;
    }

    public String getSteppingLoss()
    {
        return this.steppingLoss;
    }

    public void setSteppingLoss( String steppingLoss )
    {
        this.steppingLoss = steppingLoss;
    }

    public String getStepsAscended()
    {
        return this.stepsAscended;
    }

    public void setStepsAscended( String stepsAscended )
    {
        this.stepsAscended = stepsAscended;
    }

    public String getStepsDescended()
    {
        return this.stepsDescended;
    }

    public void setStepsDescended( String stepsDescended )
    {
        this.stepsDescended = stepsDescended;
    }

    public String getTotalGain()
    {
        return this.totalGain;
    }

    public void setTotalGain( String totalGain )
    {
        this.totalGain = totalGain;
    }

    public String getTotalLoss()
    {
        return this.totalLoss;
    }

    public void setTotalLoss( String totalLoss )
    {
        this.totalLoss = totalLoss;
    }
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId( String userId )
    {
        this.userId = userId;
    }

    public JSONObject getJSONObject()
    {
        JSONObject jsonObj = new JSONObject();
        try
        {
            jsonObj.put( "id", this.getId() );
            jsonObj.put( "flightsAscended", this.getFlightsAscended() );
            jsonObj.put( "flightsDescended", this.getFlightsDescended() );
            jsonObj.put( "rate", this.getRate() );
            jsonObj.put( "steppingGain", this.getSteppingGain() );
            jsonObj.put( "steppingLoss", this.getSteppingLoss() );
            jsonObj.put( "stepsAscended", this.getStepsAscended() );
            jsonObj.put( "stepsDescended", this.getStepsDescended() );
            jsonObj.put( "totalGain", this.getTotalGain() );
            jsonObj.put( "totalLoss", this.getTotalLoss() );
            jsonObj.put( "userId", this.getUserId() );
            jsonObj.put( "timestamp", this.getTimestamp() );
        }
        catch( JSONException e )
        {
            e.printStackTrace();
        }

        return jsonObj;
    }
}
