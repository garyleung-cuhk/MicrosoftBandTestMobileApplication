package bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gary on 1/26/16.
 */
public class Barometer
{
    private Integer id;
    private String airPressure;
    private String temperature;
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

    public String getAirPressure()
    {
        return this.airPressure;
    }

    public void setAirPressure( String airPressure )
    {
        this.airPressure = airPressure;
    }

    public String getTemperature()
    {
        return this.temperature;
    }

    public void setTemperature( String temperature )
    {
        this.temperature = temperature;
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
            jsonObj.put( "airPressure", this.getAirPressure() );
            jsonObj.put( "temperature", this.getTemperature() );
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
