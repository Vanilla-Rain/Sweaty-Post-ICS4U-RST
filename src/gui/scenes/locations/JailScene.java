/*
 * BarScene.java
 * generates the inside scenes
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.scenes.locations;

import java.awt.Image;
import backend.player.Player;
import gui.Vector2;
import gui.DrawImageOnCanvas.ImageLoader;
import gui.objects.RectangleCreator;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SceneChangeColliderNoInteract;
import gui.objects.colliders.SpeechCollider;
import gui.objects.colliders.dialog.BartenderCollider;
import gui.scenes.Scene;
import images.ImageData;

public class JailScene extends Scene {
	int identifier;

	public JailScene(int identifier) {
		super(identifier);
		System.out.print(identifier + ",");
		this.identifier = identifier;
	}

	@Override
	public void createEnvironment() {
		Image testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Desert.png");
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 6; y++) {
				int worldGen = (int) (18 * Math.random() + 1);
				switch (worldGen) // switches are used to set the tile based
									// on a random number (1-6)
				{
				case 1:
					testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
					break;
				case 2:
					testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
					break;
				case 3:
					testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
					break;
				case 4:
					testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
					break;
				case 5:
					testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
					break;
				default:
					testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor.png");
					break;
				}
				environment.add(new ImageData(testImage, x, y));
			}
		}
		environment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/NPCMale.png"), 4, 5));

		if (identifier == 8) {
			environment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/BarExitUp.png"), 1, 5));
			environment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/BarExitUp.png"), 3, 5));
			environment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/BarExitUp.png"), 5, 5));
		}
	}

	@Override
	public void createColliders() {
		addCollider(new Collider(RectangleCreator.colliderRectangle(0, 0)));
	}

	@Override
	public void createBattleColliders() {
		// TODO Auto-generated method stub
		
	}
}