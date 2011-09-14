package edu.mit.media.funf.probe.builtin;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcelable;
import edu.mit.media.funf.probe.Probe.SystemParameter;

public class ImagesProbeTest extends ProbeTestCase<ImagesProbe> {

	public ImagesProbeTest() {
		super(ImagesProbe.class);
	}
	
	public void testData() {
		Bundle params = new Bundle();
		params.putLong(SystemParameter.PERIOD.name, 0L);
		startProbe(params);
		Bundle data = getData(10);
		ArrayList<Parcelable> images = data.getParcelableArrayList(ImagesProbe.IMAGES);
		assertNotNull(images);
		assertTrue(images.size() > 0);
		
		// Running again should return an empty result
		startProbe(params);
		data = getData(10);
		images = data.getParcelableArrayList(ImagesProbe.IMAGES);
		assertNotNull(images);
		assertTrue(images.isEmpty());
	}

}