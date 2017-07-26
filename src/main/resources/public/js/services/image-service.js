
avalonApp.factory('ImageService', function($window, $location, $http, $log) {

    var equipmentSlots = ['CONSUMABLE','HEAD','BODY','LEGS','FEET','HANDS','RING','NECK','LEFT_HAND','RIGHT_HAND'];

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

    return {
        getEquipmentSlots: function() {
            return equipmentSlots.slice();      // return copy of array
        },

        getEquipmentSlotIcon: function(equipmentSlot) {
            return equipmentSlotIconsSmall[equipmentSlot];
        }
    }
});
