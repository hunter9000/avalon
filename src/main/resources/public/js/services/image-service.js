
avalonApp.factory('ImageService', function() {

    var equipmentSlotIconsSmall = {
        'BODY': '/img/equipment_slot_icons/armor-vest.png',
        'CONSUMABLE': '/img/equipment_slot_icons/armor-vest.png',
        'HEAD': '/img/equipment_slot_icons/armor-vest.png',
        'BODY': '/img/equipment_slot_icons/armor-vest.png',
        'LEGS': '/img/equipment_slot_icons/armor-vest.png',
        'FEET': '/img/equipment_slot_icons/armor-vest.png',
        'HANDS': '/img/equipment_slot_icons/armor-vest.png',
        'RING': '/img/equipment_slot_icons/armor-vest.png',
        'NECK': '/img/equipment_slot_icons/armor-vest.png',
        'LEFT_HAND': '/img/equipment_slot_icons/armor-vest.png',
        'RIGHT_HAND': '/img/equipment_slot_icons/armor-vest.png',
    };

    var materialTypeIconsSmall = {
        'CLOTH': '/img/equipment_slot_icons/armor-vest.png',
        'HIDE': '/img/equipment_slot_icons/armor-vest.png',
        'WOOD': '/img/equipment_slot_icons/armor-vest.png',
        'METAL': '/img/equipment_slot_icons/armor-vest.png',
        'GEM': '/img/equipment_slot_icons/armor-vest.png',
        'FOOD': '/img/equipment_slot_icons/armor-vest.png',
        'MISC': '/img/equipment_slot_icons/armor-vest.png',
    };

    return {
        getEquipmentSlotIcon: function(equipmentSlot) {
            return equipmentSlotIconsSmall[equipmentSlot];
        },
        getMaterialTypeIcon: function(materialType) {
            return materialTypeIconsSmall[materialType];
        },
    }
});
