package bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by bdda on 2015-06-10.
 */
public class Gyroscope {
    private Integer id;
    private String accelerationX;
    private String accelerationY;
    private String accelerationZ;
    private String angularVelocityX;
    private String angularVelocityY;
    private String angularVelocityZ;
    private String userId;
    private Long timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccelerationX()
    {
        return this.accelerationX;
    }

    public void setAccelerationX( String accelerationX )
    {
        this.accelerationX = accelerationX;
    }

    public String getAccelerationY()
    {
        return this.accelerationY;
    }

    public void setAccelerationY( String accelerationY )
    {
        this.accelerationY = accelerationY;
    }

    public String getAccelerationZ()
    {
        return this.accelerationZ;
    }

    public void setAccelerationZ( String accelerationZ )
    {
        this.accelerationZ = accelerationZ;
    }

    public String getAngularVelocityX()
    {
        return this.angularVelocityX;
    }

    public void setAngularVelocityX( String angularVelocityX )
    {
        this.angularVelocityX = angularVelocityX;
    }

    public String getAngularVelocityY()
    {
        return this.angularVelocityY;
    }

    public void setAngularVelocityY( String angularVelocityY )
    {
        this.angularVelocityY = angularVelocityY;
    }

    public String getAngularVelocityZ()
    {
        return this.angularVelocityZ;
    }

    public void setAngularVelocityZ( String angularVelocityZ )
    {
        this.angularVelocityZ = angularVelocityZ;
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
            jsonObj.put( "accelerationX", this.getAccelerationX() );
            jsonObj.put( "accelerationY", this.getAccelerationY() );
            jsonObj.put( "accelerationZ", this.getAccelerationZ() );
            jsonObj.put( "angularVelocityX", this.getAngularVelocityX() );
            jsonObj.put( "angularVelocityY", this.getAngularVelocityY() );
            jsonObj.put( "angularVelocityZ", this.getAngularVelocityZ() );
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
