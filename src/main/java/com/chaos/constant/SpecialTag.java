package com.chaos.constant;

public enum SpecialTag {
	MAIN_PAGE_TAG(0, "MainPageTag"), FAVORITIES(0, "Favorites");
	private int type;
	private String name;

	private SpecialTag(int type, String name) {
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

}
