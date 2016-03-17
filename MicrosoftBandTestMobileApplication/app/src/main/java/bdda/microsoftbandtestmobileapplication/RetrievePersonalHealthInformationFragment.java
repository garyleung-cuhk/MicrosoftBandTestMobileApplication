package bdda.microsoftbandtestmobileapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.microsoft.band.BandClient;
import com.microsoft.band.BandClientManager;
import com.microsoft.band.BandException;
import com.microsoft.band.BandIOException;
import com.microsoft.band.BandInfo;
import com.microsoft.band.BandPendingResult;
import com.microsoft.band.ConnectionState;
import com.microsoft.band.InvalidBandVersionException;
import com.microsoft.band.UserConsent;
import com.microsoft.band.sensors.BandAccelerometerEvent;
import com.microsoft.band.sensors.BandAccelerometerEventListener;
import com.microsoft.band.sensors.BandAltimeterEvent;
import com.microsoft.band.sensors.BandAltimeterEventListener;
import com.microsoft.band.sensors.BandAmbientLightEvent;
import com.microsoft.band.sensors.BandAmbientLightEventListener;
import com.microsoft.band.sensors.BandBarometerEvent;
import com.microsoft.band.sensors.BandBarometerEventListener;
import com.microsoft.band.sensors.BandCaloriesEvent;
import com.microsoft.band.sensors.BandCaloriesEventListener;
import com.microsoft.band.sensors.BandContactEvent;
import com.microsoft.band.sensors.BandContactEventListener;
import com.microsoft.band.sensors.BandDistanceEvent;
import com.microsoft.band.sensors.BandDistanceEventListener;
import com.microsoft.band.sensors.BandGsrEvent;
import com.microsoft.band.sensors.BandGsrEventListener;
import com.microsoft.band.sensors.BandGyroscopeEvent;
import com.microsoft.band.sensors.BandGyroscopeEventListener;
import com.microsoft.band.sensors.BandHeartRateEvent;
import com.microsoft.band.sensors.BandHeartRateEventListener;
import com.microsoft.band.sensors.BandPedometerEvent;
import com.microsoft.band.sensors.BandPedometerEventListener;
import com.microsoft.band.sensors.BandRRIntervalEvent;
import com.microsoft.band.sensors.BandRRIntervalEventListener;
import com.microsoft.band.sensors.BandSkinTemperatureEvent;
import com.microsoft.band.sensors.BandSkinTemperatureEventListener;
import com.microsoft.band.sensors.BandUVEvent;
import com.microsoft.band.sensors.BandUVEventListener;
import com.microsoft.band.sensors.HeartRateConsentListener;
import com.microsoft.band.sensors.SampleRate;

import java.util.ArrayList;

import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Accelerometer;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Altimeter;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.AmbientLight;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Barometer;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Calories;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Contact;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Distance;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Gsr;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Gyroscope;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.HeartRate;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Pedometer;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.RRInterval;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.SkinTemperature;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.UV;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.storageHandler.impl.MyDBHandler;

public class RetrievePersonalHealthInformationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private View rootView;
    private TextView heartRate;
    private TextView uv;
    private TextView calories;
    private TextView skinTemperature;

    private BandClient bandClient;

    private MyDBHandler dbHandler;

    private Runnable timerOne;

    private TextView pedometer;
    private TextView distance;
    private TextView accelerometer;

    private TextView contact;
    private TextView gyroscope;

    private TextView ambientLight;
    private TextView barometer;
    private TextView altimeter;

    private TextView gsr;
    private TextView rrInterval;

    private GraphView graph;
    private final Handler handler  = new Handler();
    private LineGraphSeries<DataPoint> seriesOne;
    /*
        Examples for accessing Microsoft Band Sensor
     */
    // TODO: Rename and change types and number of parameters
    public static RetrievePersonalHealthInformationFragment newInstance(String param1, String param2) {
        RetrievePersonalHealthInformationFragment fragment = new RetrievePersonalHealthInformationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public RetrievePersonalHealthInformationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_retrieve_personal_health_information, container, false);
        heartRate = ( TextView ) rootView.findViewById( R.id.heartRate );
        uv = ( TextView ) rootView.findViewById( R.id.uv );
        calories = ( TextView ) rootView.findViewById( R.id.calories );
        skinTemperature = ( TextView ) rootView.findViewById( R.id.skinTemperature );


        pedometer = ( TextView ) rootView.findViewById( R.id.pedometer );
        distance = ( TextView ) rootView.findViewById( R.id.distance );
        accelerometer = ( TextView ) rootView.findViewById( R.id.accelerometer );
        contact = ( TextView ) rootView.findViewById( R.id.contact );
        gyroscope = ( TextView ) rootView.findViewById( R.id.gyroscope );

        ambientLight = ( TextView ) rootView.findViewById( R.id.ambientLight );
        barometer = ( TextView ) rootView.findViewById( R.id.barometer );
        altimeter = ( TextView ) rootView.findViewById( R.id.altimeter);

        gsr = ( TextView ) rootView.findViewById( R.id.gsr );
        rrInterval = ( TextView ) rootView.findViewById( R.id.rrInterval );

        dbHandler = new MyDBHandler( getActivity().getApplicationContext() );

        new LoadBandInformationTask().execute();

        graph = (GraphView) rootView.findViewById(R.id.graph);
        seriesOne = new LineGraphSeries<DataPoint>();

        graph.addSeries(seriesOne);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(40);
        graph.getViewport().setMaxY(130);
        graph.getViewport().setScrollable(true);

        return rootView;
    }

    private class LoadBandInformationTask extends AsyncTask<Void, Void, Void>
    {
        protected Void doInBackground( Void ... params )
        {
            BandInfo[] pairedBands = BandClientManager.getInstance().getPairedBands();
            bandClient = BandClientManager.getInstance().create(getActivity(), pairedBands[0]);
            BandPendingResult<ConnectionState> pendingResult = bandClient.connect();
            try {
                ConnectionState state = pendingResult.await();
                if (state == ConnectionState.CONNECTED) {

                    if(bandClient.getSensorManager().getCurrentHeartRateConsent() != UserConsent.GRANTED) {
                        // user has not consented, request it      // the calling class is both an Activity and implements      // HeartRateConsentListener
                        bandClient.getSensorManager().requestHeartRateConsent( getActivity(), heartRateConsentListener );
                    }
                    else
                    {
                        startHRListener();
                    }

                    startUVListener();
                    startCaloriesListener();
                    startSkinTemperatureListener();
                    startPedometerListener();
                    startDistanceListener();
                    startAccelerometerListener();
                    startContactListener();
                    startGyroscopeListener();
                    startAmbientLightListener();
                    startAltimeterListener();
                    startBarometerListener();
                    startGsrListener();
                    startRRIntervalListener();
                }
            }
            catch(InterruptedException ex)
            {  // handle InterruptedException
            }
            catch(BandException ex) {
                // handle BandException
                ex.printStackTrace();
            }
            return null;
        }
    }

    public void onResume()
    {
        super.onResume();

        timerOne = new Runnable()
        {
            @Override
            public void run()
            {
                final DataPoint tmpDataPoint = generateSingleData();
                if( getActivity() == null )
                {
                    return;
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if( tmpDataPoint != null )
                        {
                            seriesOne.appendData( tmpDataPoint, true, 100);
                        }
                    }
                });

                handler.postDelayed( this, 1000 );
            }
        };

        handler.postDelayed(timerOne, 0);
    }

    public void onStop()
    {
        super.onStop();
        if( bandClient != null )
        {
            stopHRListener();
            stopSkinListener();
            stopUVListener();
            stopCaloriesListener();

            stopPedometerListener();
            stopDistanceListener();
            stopAccelerometerListener();
            stopContactListener();
            stopGyroscopeListener();

            stopAmbientLightListener();
            stopBarometerListener();
            stopAltimeterListener();

            stopGsrListener();
            stopRRIntervalListener();
        }
        if( timerOne != null )
        {
            timerOne = null;
        }

    }
    @Override
    public void onPause()
    {
        super.onPause();
        if( bandClient != null )
        {
            stopHRListener();
            stopSkinListener();
            stopUVListener();
            stopCaloriesListener();

            stopAmbientLightListener();
            stopBarometerListener();
            stopAltimeterListener();

            stopGsrListener();
            stopRRIntervalListener();
        }

        if( timerOne != null )
        {
            timerOne = null;
        }
    }

    private DataPoint generateSingleData()
    {
        int count = 1;
        DataPoint[] values = new DataPoint[count];
        ArrayList<HeartRate> heartRateList = new ArrayList<HeartRate>();
        heartRateList = dbHandler.getHeartRatesInLimits( count );

        for( int i = 0; i < heartRateList.size(); i++ )
        {
            double y = ( double ) heartRateList.get( i ).getHr();
            double x = ( double ) ( heartRateList.get( i ).getId() );

            DataPoint point = new DataPoint( x, y );
            values[count - i - 1] = point;
        }

        return values[0];
    }

    private BandHeartRateEventListener heartRateEventListener = new BandHeartRateEventListener() {
        @Override
        public void onBandHeartRateChanged(BandHeartRateEvent bandHeartRateEvent) {
            if( bandHeartRateEvent != null )
            {

                HeartRate tmpHeartRate = new HeartRate();
                tmpHeartRate.setHr( bandHeartRateEvent.getHeartRate() );
                tmpHeartRate.setTimestamp(bandHeartRateEvent.getTimestamp());

                updateHeartBeatTextView(Integer.toString(bandHeartRateEvent.getHeartRate()));
                dbHandler.addHeartRate( tmpHeartRate );
            }
        }
    };

    private BandUVEventListener uvEventListener = new BandUVEventListener() {
        @Override
        public void onBandUVChanged( BandUVEvent bandUVEvent )
        {
            if( bandUVEvent != null )
            {
                UV tmpUV = new UV();
                tmpUV.setLevel( bandUVEvent.getUVIndexLevel().toString() );
                tmpUV.setTimestamp(bandUVEvent.getTimestamp());

                updateUVTextView(bandUVEvent.getUVIndexLevel().toString());
                dbHandler.addUV( tmpUV );
            }
        }
    };

    private BandSkinTemperatureEventListener skinTemperatureEventListener = new BandSkinTemperatureEventListener() {
        @Override
        public void onBandSkinTemperatureChanged(BandSkinTemperatureEvent bandSkinTemperatureEvent) {
            if( bandSkinTemperatureEvent != null )
            {
                SkinTemperature tmpSkinTemperature = new SkinTemperature();
                tmpSkinTemperature.setTemperature( Float.toString(bandSkinTemperatureEvent.getTemperature()) );
                tmpSkinTemperature.setTimestamp(bandSkinTemperatureEvent.getTimestamp());

                updateSkinTemperatureTextView(Float.toString(bandSkinTemperatureEvent.getTemperature()));
                dbHandler.addSkinTemperature( tmpSkinTemperature );
            }
        }
    };

    private HeartRateConsentListener heartRateConsentListener = new HeartRateConsentListener() {
        @Override
        public void userAccepted( boolean b )
        {
            if (b == true) {
                // Consent has been given, start HR sensor event listener
                startHRListener();
            } else {
//                // Consent hasn't been given
//                appendToUI(String.valueOf(b));
            }
        }
    };

    public void updateHeartBeatTextView( final String str )
    {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                heartRate.setText( str );
            }
        });
    }

    public void updateUVTextView( final String str )
    {
        getActivity().runOnUiThread( new Runnable() {
            @Override
            public void run() {
                uv.setText( str );
            }
        });
    }

    public void updateSkinTemperatureTextView( final String str )
    {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                skinTemperature.setText( str );
            }
        });
    }

    public void startHRListener()
    {
        try
        {
            bandClient.getSensorManager().registerHeartRateEventListener(heartRateEventListener);
        }
        catch( BandException e )
        {

        }
    }

    public void stopHRListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterHeartRateEventListener(heartRateEventListener);
        }
        catch( BandIOException e )
        {

        }

    }

    public void startUVListener()
    {
        try
        {
            bandClient.getSensorManager().registerUVEventListener(uvEventListener);
        }
        catch( BandException e )
        {

        }
    }

    public void stopUVListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterUVEventListener(uvEventListener);
        }
        catch( BandException e )
        {

        }
    }

    public void startSkinTemperatureListener()
    {
        try
        {
            bandClient.getSensorManager().registerSkinTemperatureEventListener(skinTemperatureEventListener);
        }
        catch( BandException e )
        {

        }
    }

    public void stopSkinListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterSkinTemperatureEventListener(skinTemperatureEventListener);
        }
        catch( BandIOException e )
        {

        }
    }

    public void startPedometerListener()
    {
        try
        {
            bandClient.getSensorManager().registerPedometerEventListener(pedometerEventListener);
        }
        catch( BandException e )
        {

        }
    }

    public void stopPedometerListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterPedometerEventListener(pedometerEventListener);
        }
        catch( BandException e )
        {

        }
    }

    public void startDistanceListener()
    {
        try
        {
            bandClient.getSensorManager().registerDistanceEventListener(distanceEventListener);
        }
        catch ( BandException e )
        {

        }
    }

    public void stopDistanceListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterDistanceEventListener(distanceEventListener);
        }
        catch ( BandException e )
        {

        }
    }

    public void startAccelerometerListener()
    {
        try
        {
            bandClient.getSensorManager().registerAccelerometerEventListener(accelerometerEventListener, SampleRate.MS128);
        }
        catch( BandException e )
        {

        }
    }

    public void stopAccelerometerListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterAccelerometerEventListener(accelerometerEventListener);
        }
        catch( BandException e )
        {

        }
    }

    public void startContactListener()
    {
        try
        {
            bandClient.getSensorManager().registerContactEventListener(contactEventListener);
        }
        catch( BandException e )
        {

        }
    }

    public void stopContactListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterContactEventListener(contactEventListener);
        }
        catch( BandException e )
        {

        }
    }

    public void startGyroscopeListener()
    {
        try
        {
            bandClient.getSensorManager().registerGyroscopeEventListener(gyroscopeEventListener, SampleRate.MS128);
        }
        catch( BandException e )
        {

        }
    }

    public void stopGyroscopeListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterGyroscopeEventListener(gyroscopeEventListener);
        }
        catch( BandException e )
        {

        }
    }
    public void startCaloriesListener()
    {
        try
        {
            bandClient.getSensorManager().registerCaloriesEventListener(caloriesEventListener);
        }
        catch( BandException e )
        {

        }
    }

    public void stopCaloriesListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterCaloriesEventListener(caloriesEventListener);
        }
        catch( BandIOException e )
        {

        }
    }

    public void stopGsrListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterGsrEventListener(gsrEventListener);
        }
        catch( BandIOException e )
        {

        }
    }

    public void stopRRIntervalListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterRRIntervalEventListener(rrIntervalEventListener);
        }
        catch( BandIOException e )
        {

        }
    }
    public void startGsrListener()
    {
        try
        {
            bandClient.getSensorManager().registerGsrEventListener(gsrEventListener);
        }
        catch( InvalidBandVersionException e )
        {

        }
        catch( BandException e )
        {

        }
    }

    public void startRRIntervalListener()
    {
        try
        {
            bandClient.getSensorManager().registerRRIntervalEventListener(rrIntervalEventListener);
        }
        catch( InvalidBandVersionException e )
        {

        }
        catch( BandException e )
        {

        }
    }

    public void stopAmbientLightListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterAmbientLightEventListener(ambientLightEventListener);
        }
        catch( BandIOException e )
        {

        }
    }

    public void stopBarometerListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterBarometerEventListener(barometerEventListener);
        }
        catch( BandIOException e )
        {

        }
    }

    public void stopAltimeterListener()
    {
        try
        {
            bandClient.getSensorManager().unregisterAltimeterEventListener(altimeterEventListener);
        }
        catch( BandIOException e )
        {

        }
    }

    public void startAmbientLightListener()
    {
        try
        {
            bandClient.getSensorManager().registerAmbientLightEventListener(ambientLightEventListener);
        }
        catch( InvalidBandVersionException e )
        {

        }
        catch( BandException e )
        {

        }
    }

    public void startBarometerListener()
    {
        try
        {
            bandClient.getSensorManager().registerBarometerEventListener(barometerEventListener);
        }
        catch( InvalidBandVersionException e )
        {

        }
        catch( BandException e )
        {

        }
    }

    public void startAltimeterListener()
    {
        try
        {
            bandClient.getSensorManager().registerAltimeterEventListener(altimeterEventListener);
        }
        catch( InvalidBandVersionException e )
        {

        }
        catch( BandException e )
        {

        }
    }

    private BandPedometerEventListener pedometerEventListener = new BandPedometerEventListener() {
        @Override
        public void onBandPedometerChanged( BandPedometerEvent bandPedometerEvent )
        {
            if( bandPedometerEvent != null )
            {
                Pedometer tmpPedometer = new Pedometer();
                tmpPedometer.setTotalSteps( Long.toString(bandPedometerEvent.getTotalSteps() ) );
                tmpPedometer.setTimestamp(bandPedometerEvent.getTimestamp());
                dbHandler.addPedometer(tmpPedometer);
                updatePedometerTextView(bandPedometerEvent.toString());
            }
        }
    };

    private BandDistanceEventListener distanceEventListener = new BandDistanceEventListener() {
        @Override
        public void onBandDistanceChanged(BandDistanceEvent bandDistanceEvent) {
            if( bandDistanceEvent != null )
            {
                Distance tmpDistance = new Distance();
                tmpDistance.setMotionType( bandDistanceEvent.getMotionType().toString() );
                tmpDistance.setPace(Float.toString(bandDistanceEvent.getPace()));
                tmpDistance.setSpeed(Float.toString(bandDistanceEvent.getSpeed()));
                tmpDistance.setTotalDistance(Long.toString(bandDistanceEvent.getTotalDistance()));
                tmpDistance.setTimestamp(System.currentTimeMillis());

                dbHandler.addDistance(tmpDistance);
                updateDistanceTextView(bandDistanceEvent.toString());
            }
        }
    };

    private BandAccelerometerEventListener accelerometerEventListener = new BandAccelerometerEventListener() {
        @Override
        public void onBandAccelerometerChanged(BandAccelerometerEvent bandAccelerometerEvent) {
            if( bandAccelerometerEvent != null )
            {
                Accelerometer tmpAccelerometer = new Accelerometer();
                tmpAccelerometer.setAccelerationX( Float.toString(bandAccelerometerEvent.getAccelerationX() ) );
                tmpAccelerometer.setAccelerationY(Float.toString(bandAccelerometerEvent.getAccelerationY()));
                tmpAccelerometer.setAccelerationZ(Float.toString(bandAccelerometerEvent.getAccelerationZ()));
                tmpAccelerometer.setTimestamp(System.currentTimeMillis());

                dbHandler.addAccelerometer(tmpAccelerometer);
                updateAccelerometerTextView(bandAccelerometerEvent.toString());
            }
        }
    };


    private BandContactEventListener contactEventListener = new BandContactEventListener() {
        @Override
        public void onBandContactChanged(BandContactEvent bandContactEvent) {
            if (bandContactEvent != null) {
                Contact tmpContact = new Contact();
                tmpContact.setContact(bandContactEvent.getContactState().toString());
                tmpContact.setTimestamp(bandContactEvent.getTimestamp());

                dbHandler.addContact(tmpContact);
                updateContactTextView(bandContactEvent.getContactState().toString());
            }
        }
    };

    private BandGyroscopeEventListener gyroscopeEventListener = new BandGyroscopeEventListener() {
        @Override
        public void onBandGyroscopeChanged(BandGyroscopeEvent bandGyroscopeEvent) {
            if( bandGyroscopeEvent != null )
            {
                Gyroscope tmpGyroscope = new Gyroscope();
                tmpGyroscope.setAccelerationX( Float.toString( bandGyroscopeEvent.getAccelerationX()));
                tmpGyroscope.setAccelerationY(Float.toString(bandGyroscopeEvent.getAccelerationY()));
                tmpGyroscope.setAccelerationZ(Float.toString(bandGyroscopeEvent.getAccelerationZ()));
                tmpGyroscope.setAngularVelocityX(Float.toString(bandGyroscopeEvent.getAngularVelocityX()));
                tmpGyroscope.setAngularVelocityY(Float.toString(bandGyroscopeEvent.getAngularVelocityY()));
                tmpGyroscope.setAngularVelocityZ(Float.toString(bandGyroscopeEvent.getAngularVelocityZ()));
                tmpGyroscope.setTimestamp(System.currentTimeMillis());

                dbHandler.addGyroscope(tmpGyroscope);
                updateGyroscopeTextView(bandGyroscopeEvent.toString());
            }
        }
    };

    private BandCaloriesEventListener caloriesEventListener = new BandCaloriesEventListener() {
                @Override
        public void onBandCaloriesChanged(BandCaloriesEvent bandCaloriesEvent) {
            if (bandCaloriesEvent != null) {

                Calories tmpCalories = new Calories();
                tmpCalories.setCalories(Long.toString(bandCaloriesEvent.getCalories()));
                tmpCalories.setTimestamp(bandCaloriesEvent.getTimestamp());

                dbHandler.addCalories(tmpCalories);
                updateCaloriesTextView(bandCaloriesEvent.toString());
            }
        }
    };

    private BandAmbientLightEventListener ambientLightEventListener = new BandAmbientLightEventListener() {
        @Override
        public void onBandAmbientLightChanged(BandAmbientLightEvent bandAmbientLightEvent) {
            if (bandAmbientLightEvent != null) {
                updateAmbientLightTextView(bandAmbientLightEvent.toString());
                AmbientLight tmpAmbientLight = new AmbientLight();
                tmpAmbientLight.setBrightness(bandAmbientLightEvent.getBrightness());
                tmpAmbientLight.setTimestamp(bandAmbientLightEvent.getTimestamp());
                dbHandler.addAmbientLight(tmpAmbientLight);
            }
        }
    };

    private BandBarometerEventListener barometerEventListener = new BandBarometerEventListener() {
        @Override
        public void onBandBarometerChanged(BandBarometerEvent bandBarometerEvent) {
            if (barometerEventListener != null) {
                updateBarometerTextView( bandBarometerEvent.toString() );
                Barometer tmpBarometer = new Barometer();
                tmpBarometer.setAirPressure(Double.toString(bandBarometerEvent.getAirPressure()));
                tmpBarometer.setTemperature(Double.toString(bandBarometerEvent.getTemperature()));
                tmpBarometer.setTimestamp(bandBarometerEvent.getTimestamp());
                dbHandler.addBarometer(tmpBarometer);
            }
        }
    };

    private BandAltimeterEventListener altimeterEventListener = new BandAltimeterEventListener() {
        @Override
        public void onBandAltimeterChanged(BandAltimeterEvent bandAltimeterEvent) {
            if (bandAltimeterEvent != null) {
                updateAltimeterTextView( bandAltimeterEvent.toString() );
                Altimeter tmpAltimeter = new Altimeter();
                tmpAltimeter.setFlightsAscended(Long.toString(bandAltimeterEvent.getFlightsAscended()));
                tmpAltimeter.setFlightsDescended(Long.toString(bandAltimeterEvent.getFlightsDescended()));
                tmpAltimeter.setRate(Float.toString(bandAltimeterEvent.getRate()));
                tmpAltimeter.setSteppingGain(Long.toString(bandAltimeterEvent.getSteppingGain()));
                tmpAltimeter.setSteppingLoss(Long.toString(bandAltimeterEvent.getSteppingLoss()));
                tmpAltimeter.setStepsAscended(Long.toString(bandAltimeterEvent.getStepsAscended()));
                tmpAltimeter.setStepsDescended(Long.toString(bandAltimeterEvent.getStepsDescended()));
                tmpAltimeter.setTotalGain(Long.toString(bandAltimeterEvent.getFlightsDescended()));
                tmpAltimeter.setTotalLoss(Long.toString(bandAltimeterEvent.getFlightsDescended()));
                tmpAltimeter.setTimestamp(bandAltimeterEvent.getTimestamp());
                dbHandler.addAltimeter(tmpAltimeter);
            }
        }
    };

    private BandGsrEventListener gsrEventListener = new BandGsrEventListener() {
        @Override
        public void onBandGsrChanged(BandGsrEvent bandGsrEvent) {
            if( bandGsrEvent != null )
            {
                Gsr tmpGsr = new Gsr();
                tmpGsr.setResistance(bandGsrEvent.getResistance());
                tmpGsr.setTimestamp(bandGsrEvent.getTimestamp());
                updateGsrTextView(Integer.toString(tmpGsr.getResistance()) + " kohms");
                dbHandler.addGsr(tmpGsr);
            }
        }
    };

    private BandRRIntervalEventListener rrIntervalEventListener = new BandRRIntervalEventListener() {
        @Override
        public void onBandRRIntervalChanged(BandRRIntervalEvent bandRRIntervalEvent) {
            if( bandRRIntervalEvent != null )
            {
                RRInterval tmpRRInterval = new RRInterval();
                tmpRRInterval.setInterval(Double.toString(bandRRIntervalEvent.getInterval()));
                tmpRRInterval.setTimestamp(bandRRIntervalEvent.getTimestamp());
                updateRRIntervalTextView(tmpRRInterval.getInterval() + " seconds");
                dbHandler.addRRInterval(tmpRRInterval);
            }
        }
    };

    public void updateRRIntervalTextView( final String str )
    {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                rrInterval.setText( str );
            }
        });
    }

    public void updateGsrTextView( final String str )
    {
        getActivity().runOnUiThread( new Runnable() {
            @Override
            public void run() {
                gsr.setText( str );
            }

        });
    }

    public void updateAmbientLightTextView( final String str )
    {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ambientLight.setText( str );
            }
        });
    }

    public void updateBarometerTextView( final String str )
    {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                barometer.setText( str );
            }
        });
    }

    public void updateAltimeterTextView( final String str )
    {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                altimeter.setText( str );
            }
        });
    }

    private void updateDistanceTextView( final String str )
    {
        getActivity().runOnUiThread( new Runnable(){
            @Override
            public void run(){
                distance.setText( str );
            }
        });
    }

    public void updateAccelerometerTextView( final String str )
    {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                accelerometer.setText( str );
            }
        });
    }

    public void updateGyroscopeTextView( final String str )
    {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                gyroscope.setText( str );
            }
        });
    }

    public void updateContactTextView( final String str )
    {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                contact.setText( str );
            }
        });
    }

    public void updatePedometerTextView( final String str )
    {
        getActivity().runOnUiThread( new Runnable() {
            @Override
            public void run() {
                pedometer.setText( str );
            }
        });
    }

    public void updateCaloriesTextView( final String str )
    {
        getActivity().runOnUiThread( new Runnable() {
            @Override
            public void run() {
                calories.setText( str );
            }
        });
    }
}
