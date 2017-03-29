package com.ludwigwiren

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id


// Created by ludwi on date 2017-03-29
@Entity
data class Reader(
        @Id
        private var username: String = "",
        private var password: String = "",
        val fullname: String? = null
) : UserDetails {

    private val serialVersionUID = 1L


    override fun getAuthorities(): MutableCollection<out GrantedAuthority>
            = arrayListOf(SimpleGrantedAuthority("READER"))


    override fun isEnabled() = true

    override fun getUsername(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}