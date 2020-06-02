package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.*;

import java.awt.*;

public class RectBullet extends BaseBullet {
	private static final int SPEED = 6;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	
	Rectangle rect = new Rectangle();
	
	private int x, y;
	private Dir dir;
	
	private boolean living = true;
	TankFrame tf = null;
	private Group group = Group.BAD;
	
	public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tf = tf;
		
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
		
		tf.bulletList.add(this);
				
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void paint(Graphics g) {
		if(!living) {
			tf.bulletList.remove(this);
		}
		
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 20, 20);
		g.setColor(c);
		
		move();
	}
	
	private void move() {
		
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
		
		//update rect
		rect.x = this.x;
		rect.y = this.y;
		
		if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
		
	}

	public void collideWith(BaseTank tank) {
		if(this.group == tank.getGroup()) return;
		
		if(rect.intersects(tank.rec)) {
			tank.die();
			this.die();
			int eX = tank.getX() + Tank.WIDTH/2 - Expolde.WIDTH/2;
			int eY = tank.getY() + Tank.HEIGHT/2 - Expolde.HEIGHT/2;
			tf.expoldes.add(tf.gf.createExplode(eX, eY, tf));
		}
		
	}

	private void die() {
		this.living = false;
	}
}