package io.github.dre2n.commons.compatibility;

public class CompatibilityHandler {
	
	private static CompatibilityHandler instance;
	
	private Version version;
	private Internals internals;
	private boolean spigot;
	
	public CompatibilityHandler() {
		instance = this;
		
		version = Version.getByServer();
		
		if (Package.getPackage("net.glowstone") != null) {
			internals = Internals.GLOWSTONE;
			
		} else if (Package.getPackage("net.minecraft.server.v1_9_R1") != null) {
			internals = Internals.v1_9_R1;
			
		} else if (Package.getPackage("net.minecraft.server.v1_8_R3") != null) {
			internals = Internals.v1_8_R3;
			
		} else if (Package.getPackage("net.minecraft.server.v1_8_R2") != null) {
			internals = Internals.v1_8_R2;
			
		} else if (Package.getPackage("net.minecraft.server.v1_8_R1") != null) {
			internals = Internals.v1_8_R1;
			
		} else if (Package.getPackage("net.minecraft.server.v1_7_R4") != null) {
			internals = Internals.v1_7_R4;
			
		} else if (Package.getPackage("net.minecraft.server.v1_7_R3") != null) {
			internals = Internals.v1_7_R3;
			
		} else if (Package.getPackage("net.minecraft.server.v1_7_R2") != null) {
			internals = Internals.v1_7_R2;
			
		} else if (Package.getPackage("net.minecraft.server.v1_7_R1") != null) {
			internals = Internals.v1_7_R1;
			
		} else {
			for (Package internal : Package.getPackages()) {
				if (internal.getName().matches("net.minecraft.server.v1_[4-6]_.*")) {
					internals = Internals.OUTDATED;
				}
			}
		}
		
		if (internals == null) {
			internals = Internals.UNKNOWN;
		}
		
		spigot = Package.getPackage("org.spigotmc") != null;
	}
	
	/**
	 * Creates a new instance if the statically saved instance is null.
	 * 
	 * @return the instance
	 */
	public static CompatibilityHandler getInstance() {
		if (instance == null) {
			new CompatibilityHandler();
		}
		
		return instance;
	}
	
	/**
	 * @return the Minecraft version
	 */
	public Version getVersion() {
		return version;
	}
	
	/**
	 * @return the package version of the server internals
	 */
	public Internals getInternals() {
		return internals;
	}
	
	/**
	 * @return if the server software implements the Spigot API
	 */
	public boolean isSpigot() {
		return spigot;
	}
	
}