package com.applets;
import java.awt.*;


import java.applet.Applet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseDemo extends Applet implements MouseListener, MouseMotionListener 
{
	int mx=0, my=0;
	String msg="";
	
	public void init() 
	{
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mx=e.getX();
		my=e.getY();
		showStatus("Currently mouse dragged"+mx+" "+my);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mx=e.getX();
		my=e.getY();
		showStatus("Currently mouse is moved at"+mx+" "+my);
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		mx=20;
		my=40;
		msg="mouse clicked";
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mx=30;
		my=60;
		msg="mouse pressed";
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mx=30;
		my=60;
		msg="mouse released";
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		mx=40;
		my=80;
		msg="mouse entered";
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		mx=40;
		my=50;
		msg="mouse exited";
		repaint();
	}
	public void paint(Graphics g)
	{
		g.drawString("handling mouse events",30,20);
		g.drawString(msg,60,40);
	}
	
	
}
