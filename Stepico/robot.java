public static class Main {
	public static void main(String[] args) {

	}

	public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
		RobotConnection robotconnection;
		int attempts = 0;
		try {
			robotconnection = robotConnectionManager.getConnection();
			
		} catch (RobotConnectionException e1) {
			attempts++;
			try {
				robotconnection = robotConnectionManager.getConnection();
			} catch (RobotConnectionException e11) {
				attempts++;
				try {
					robotconnection = robotConnectionManager.getConnection();
				} catch (RobotConnectionException e111) {
					throw e111;
				}
			}
		} finally {

		}
		try {
			robotconnection.moveRobotTo(toX, toY);
		} catch (RobotConnectionException e1) {
			attempts++;
			if (attempts<3) {
				try {
					robotconnection.close();
					robotconnection = robotConnectionManager.getConnection();
					robotconnection.moveRobotTo(toX, toY);
				} catch (RobotConnectionException e11) {
					attempts++;
					if (attempts<3) {
						try {
							robotconnection.close();
							robotconnection = robotConnectionManager.getConnection();
							robotconnection.moveRobotTo(toX, toY);
						} catch (RobotConnectionException e111) {
							throw e111;
						} catch (Exception e112) {
							throw e112;
						} finally {
							robotconnection.close();
						}
					} else throw e11;
				} catch (Exception e12) {
					throw e12;
				} finally {
					robotconnection.close();
				}	
			} else throw e1;
		} catch (Exception e2) {
			throw e2;
		} finally {
			try {robotconnection.close();}
			catch (RobotConnectionException e3) {}
			

		}
			
	}

}