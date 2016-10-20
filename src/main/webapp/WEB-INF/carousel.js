/**
 * 
 */
var startingPlate = 3;

$(document).ready(function() {
	$('.carousel_data .carousel_plate').each(function() {
		$('#carousel').append($(this).find('.image').html());
	});
	createCarousel();
	showCaption();
});

function createCarousel() {
	$('div#carousel').roundabout({
		startingChild : window.startingPlate,
		childSelector : 'img',
		tilt : -4.5,
		minOpacity : 1,
		minScale : .45,
		duration : 1200,
		clickToFocus : true,
		clickToFocusCallback : showCaption
	});
	createCustomButtons();
}

function createCustomButtons() {

	$('.nextPlate').click(function() {
		hideCaption();
		$('div#carousel').roundabout('animateToNextChild', showCaption);
	});

	$('.prevPlate').click(function() {
		hideCaption();
		$('div#carousel').roundabout('animateToPreviousChild', showCaption);
	});

	$('div#carousel img').click(function() {
		hideCaption();
	});
}

function hideCaption() {
	$('#captions').animate({
		'opacity' : 0
	}, 250);
}

function showCaption() {
	var childInFocus = $('div#carousel').data('roundabout').childInFocus
	var setCaption = $(
			'.carousel_data .carousel_plate .caption:eq(' + childInFocus + ')')
			.html();
	$('#captions').html(setCaption);
	var newHeight = $('#captions').height() + 'px';
	$('.caption_container').animate({
		'height' : newHeight
	}, 500, function() {
		$('#captions').animate({
			'opacity' : 1
		}, 250);
	});

}