package object.staticobjects;

import javax.media.opengl.GL2;

import object.MeshObjectPart;
import object.ObjectPart;
import object.RenderContainer;
import object.SceneObject;
import object.StaticRender;
import object.TexturedObject;
import object.RenderContainer.RenderingMode;
import object.modification.Modification;
import object.modification.RotateModification;
import object.modification.TranslateModification;
import assignment.Mesh;
import assignment.ProceduralMeshFactory;

import com.jogamp.opengl.util.texture.Texture;

public class FuseBox implements TexturedObject, RenderContainer {

	private StaticRender render;

	public FuseBox(Texture[] textures, int m, int n) {
		if (textures.length != 5) {
			throw new IllegalArgumentException(
					"Supply 5 textures for floor and walls.");
		}

		Mesh meshFront = ProceduralMeshFactory
				.createPlane(0.5, 0.7, m, n, 1, 1);

		Modification frontTranslate = new TranslateModification(0, 0.2, 0);

		ObjectPart front = new MeshObjectPart(meshFront, textures[0],
				new Modification[0], new Modification[] { frontTranslate });

		Mesh meshSideOne = ProceduralMeshFactory.createPlane(0.5, 0.2, m, n, 1,
				1);

		Modification sideOneTranslate = new TranslateModification(0, 0.1, 0.35);
		Modification sideOneRotate = new RotateModification(90, 1.0, 0, 0);

		ObjectPart sideOne = new MeshObjectPart(meshSideOne, textures[1],
				new Modification[] { sideOneTranslate, sideOneRotate },
				new Modification[0]);

		Mesh meshSideTwo = ProceduralMeshFactory.createPlane(0.5, 0.2, m, n, 1,
				1);

		Modification sideTwoTranslate = new TranslateModification(0, 0.1, -0.35);
		Modification sideTwoRotateOne = new RotateModification(-90, 1.0, 0, 0);

		ObjectPart sideTwo = new MeshObjectPart(meshSideTwo, textures[2],
				new Modification[] { sideTwoTranslate, sideTwoRotateOne, },
				new Modification[0]);

		Mesh meshSideThree = ProceduralMeshFactory.createPlane(0.7, 0.2,
				m, n, 1, 1);

		Modification sideThreeTranslate = new TranslateModification(0.25,
			0.1, 0);
		Modification sideThreeRotateOne = new RotateModification(90, 0, 1.0, 0);
		Modification sideThreeRotateTwo = new RotateModification(90, 1.0, 0, 0);

		ObjectPart sideThree = new MeshObjectPart(meshSideThree, textures[3],
				new Modification[] { sideThreeTranslate, sideThreeRotateOne, sideThreeRotateTwo },
				new Modification[0]);

		Mesh meshSideFour = ProceduralMeshFactory.createPlane(0.7, 0.2, m,
				n, 1, 1);

		Modification sideFourTranslate = new TranslateModification(-0.25,
				0.1, 0);
		Modification sideFourRotateOne = new RotateModification(90, 0, 1.0, 0);
		Modification sideFourRotateTwo = new RotateModification(-90, 1.0, 0, 0);

		ObjectPart sideFour = new MeshObjectPart(meshSideFour, textures[4],
				new Modification[] { sideFourTranslate, sideFourRotateOne, sideFourRotateTwo }, new Modification[0]);

		SceneObject sceneObject = new SceneObject(new ObjectPart[] { front,
				sideOne, sideTwo, sideThree, sideFour });
		render = new StaticRender(sceneObject);
	}

	public void setTextures(Texture[] textures) {
		this.render.getSceneObject().setTextures(textures);
	}

	public void showTextures(boolean showTextures) {
		this.render.showTextures(showTextures);
	}

	@Override
	public void render(GL2 gl) {
		render.render(gl);
	}

	@Override
	public void setRenderingMode(RenderingMode mode) {
		this.render.setRenderingMode(mode);
	}

}
