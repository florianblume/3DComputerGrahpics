package lamp;

import javax.media.opengl.GL2;

public interface LampAnimator {
	
	public void start();
	
	public void pause();
	
	public void stop();
	
	public void animateBase(GL2 gl);
	
	public void animateLowerArm(GL2 gl);
	
	public void animateJoint(GL2 gl);
	
	public void animateUpperArm(GL2 gl);
	
	public void animateHead(GL2 gl);

}
