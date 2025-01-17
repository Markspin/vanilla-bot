package scripts;

import rscvanilla.bot.mudclient.models.Position;
import rscvanilla.bot.script.ScriptDependencyContext;
import rscvanilla.bot.script.antiban.ScriptAntiBanParams;
import rscvanilla.bot.script.template.RunnableScript;

public class CamelotPowerFlaxer extends RunnableScript {

    private final static int FLAX_ID = 675;

    private State action;

    public CamelotPowerFlaxer(ScriptDependencyContext dependencyContext, ScriptAntiBanParams argumentContext) {
        super(dependencyContext, argumentContext);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void loop() {
        waitFor(500);

        var newState = getAction();
        if (newState != this.action) {
            print("STATE: " + this.action + " -> " + newState);
        }

        if (getFatigue() > 90) {
            useSleepingBag();
            waitFor(4000);
            return;
        }

        this.action = newState;

        switch (action) {
            case PICK -> pickFlax();
            case WALK_TO_SPIN -> walkToSpin();
            case SPIN -> spin();
            case WALK_TO_PICK -> walkToPick();
            default -> throw new IllegalStateException();
        }

    }

    private State getAction() {
        if (isAtField()) {
            if (isInventoryFullOfFlax()) {
                return State.WALK_TO_SPIN;
            } else {
                return State.PICK;
            }
        } else if (isOnSpinningHouseSecondFloor()) {
            if (isInventoryFull() && isItemInInventory(675) || isItemInInventory(676)) {
                return State.SPIN;
            } else {
                return State.WALK_TO_PICK;
            }
        } else {
            if (isInventoryFullOfFlax()) {
                return State.WALK_TO_SPIN;
            } else {
                return State.WALK_TO_PICK;
            }
        }
    }

    private void walkToSpin() {
        walkToTile(503, 479);
        walkToTile(511, 466);
        walkToTile(521, 465);

        if (isInFrontOfSpinningHouse()) {
            if (isDoorClosed()) {
                openDoor();
            } else {
                walkToTile(524, 463);
            }
        }

        if (isOnSpinningHouseFirstFloor()) {
            if (isInventoryFullOfFlax()) {
                atGroundObject(5, 525, 462);
            }
        }
    }

    private void walkToPick() {
        if (isOnSpinningHouseSecondFloor()) {
            atGroundObject(6, 525, 1406);
            return;
        }

        if (isOnSpinningHouseFirstFloor()) {
            if (isWallObjectReachable(2, 522, 465)) {
                atWallObject(2, 522, 465);
                return;
            }
        }

        walkToTile(511, 471);
        walkToTile(503, 483);
        walkToTile(490, 486);
    }

    private void spin() {
        if (isItemInInventory(FLAX_ID)) {
            useInventoryItemOnGroundObject(FLAX_ID, 121);
        } else {
            dropAllInventoryItems(676);
        }
    }

    private boolean isAtField() {
        return isPosInDistanceOfCurrentPos(490, 486, 15);
    }

    private boolean isOnSpinningHouseSecondFloor() {
        return isCurrentPosInRectangle(new Position(525, 1406), new Position(522, 1411));
    }

    public void pickFlax() {
        atGroundObject(313, 489, 486);
    }

    private boolean isOnSpinningHouseFirstFloor() {
        return isCurrentPosInRectangle(new Position(525, 462), new Position(522, 467));
    }

    private void openDoor() {
        atWallObject(2, 522, 465);
    }

    private boolean isDoorClosed() {
        return isWallObjectReachable(2, 522, 465);
    }

    public boolean isInFrontOfSpinningHouse() {
        return isPosInDistanceOfCurrentPos(521, 465, 0);
    }

    public boolean isInventoryFullOfFlax() {
        return isItemInInventory(FLAX_ID, 29);
    }

    @Override
    protected void onChatMessageReceived(String sender, String message) { }

    @Override
    protected void onGameMessageReceived(String message) { }

    private enum State {
        PICK,
        WALK_TO_SPIN,
        SPIN,
        WALK_TO_PICK
    }
}

