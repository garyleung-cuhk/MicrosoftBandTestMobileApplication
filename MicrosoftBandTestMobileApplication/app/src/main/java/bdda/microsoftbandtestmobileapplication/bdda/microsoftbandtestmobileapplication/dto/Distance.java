package bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by bdda on 2015-06-10.
 */
public class Distance {
    private Integer id;
    private String motionType;
    private String pace;
    private String speed;
    private String totalDistance;
    private String userId;

    private Long timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotionType()
    {
        return this.motionType;
    }

    public void setMotionType( String motionType )
    {
        this.motionType = motionType;
    }

    public String getPace()
    {
        return this.pace;
    }

    public void setPace( String pace )
    {
        this.pace = pace;
    }

    public String getSpeed()
    {
        return this.speed;
    }

    public void setSpeed( String speed )
    {
        this.speed = speed;
    }

    public String getTotalDistance()
    {
        return this.totalDistance;
    }

    public void setTotalDistance( String totalDistance )
    {
        this.totalDistance = totalDistance;
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
            jsonObj.put( "motionType", this.getMotionType() );
            jsonObj.put( "pace", this.getPace() );
            jsonObj.put( "speed", this.getSpeed() );
            jsonObj.put( "totalDistance", this.getTotalDistance() );
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
