package com.shiftkey.codingchallenge

import com.google.common.truth.Truth.assertThat
import com.shiftkey.codingchallenge.domain.usecase.GetShiftListCase
import com.shiftkey.codingchallenge.domain.usecase.ShiftUseCase
import com.shiftkey.codingchallenge.domain.util.OrderType
import com.shiftkey.codingchallenge.domain.util.getColor
import com.shiftkey.codingchallenge.repository.ShiftFakeRepository
import com.shiftkey.codingchallenge.ui.theme.Purple200
import com.shiftkey.codingchallenge.view.shiftlist.ShiftListViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/** Class to test the ShiftListViewModel */
class ShiftListViewModelTest {

    private lateinit var viewModel: ShiftListViewModel
    private var shiftFakeRepository: ShiftFakeRepository = ShiftFakeRepository()

    /** Setup the fake data */
    @Before
    fun setup() {
        viewModel = ShiftListViewModel(ShiftUseCase(GetShiftListCase(shiftFakeRepository)))
    }

    /** ShiftListViewModel init states test */
    @Test
    fun testShiftInitViewModelStates() {
        Assert.assertFalse(viewModel.state.value.isOrderSectionVisible)
        Assert.assertEquals(OrderType.Ascending, viewModel.state.value.shiftOrder.orderType)
    }

    /** Util simple test */
    @Test
    fun testColorUtil() {
        val result = getColor("#088F8F").toString().lowercase()
        val compare = Purple200.toString().lowercase()
        assertThat(result).contains(compare)
    }
}