package avalon.model.ability;


import avalon.model.CellEntityModel;
import avalon.model.dungeons.CellModel;

//
public abstract class AbilityHandler {
	// handles the ability hitting the given target, either by doing damage, applying a buff/debuff
	public void handleEnemyTargetAbility(CellEntityModel target) { }
	public void handleGroundTargetAbility(CellModel groundTarget) { }		// applies a buff to the ground?
	public void handleSelfTargetAbility(CellEntityModel me) { }
}





